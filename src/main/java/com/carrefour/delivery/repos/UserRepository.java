package com.carrefour.delivery.repos;

import com.carrefour.delivery.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email) ;
    boolean existsByEmailIgnoreCase(String email);
}
