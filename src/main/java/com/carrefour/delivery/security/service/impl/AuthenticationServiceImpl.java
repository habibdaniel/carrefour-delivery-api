package com.carrefour.delivery.security.service.impl;


import com.carrefour.delivery.domain.User;
import com.carrefour.delivery.repos.UserRepository;
import com.carrefour.delivery.security.dao.request.SignUpRequest;
import com.carrefour.delivery.security.dao.request.SigninRequest;
import com.carrefour.delivery.security.dao.response.JwtAuthenticationResponse;
import com.carrefour.delivery.security.service.AuthenticationService;
import com.carrefour.delivery.security.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        /*var user = User.builder().firstName(request.getFirstName()).lastName(request.getLastName())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();*/

        User user = new User() ; // to complete
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            var user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
            var jwt = jwtService.generateToken(user);
            return JwtAuthenticationResponse.builder().token(jwt).user(user).build();
        } catch (AuthenticationException e) {
            return JwtAuthenticationResponse.builder().token(null).user(null).build();
        }
    }
}
