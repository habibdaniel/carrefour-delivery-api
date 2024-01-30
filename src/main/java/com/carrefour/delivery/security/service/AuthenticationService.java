package com.carrefour.delivery.security.service;


import com.carrefour.delivery.security.dao.request.SignUpRequest;
import com.carrefour.delivery.security.dao.request.SigninRequest;
import com.carrefour.delivery.security.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
