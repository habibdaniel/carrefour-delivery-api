package com.carrefour.delivery.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceSecurity {
    UserDetailsService userDetailsService();
}
