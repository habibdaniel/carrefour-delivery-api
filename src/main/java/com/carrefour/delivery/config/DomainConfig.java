package com.carrefour.delivery.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("com.carrefour.delivery.domain")
@EnableJpaRepositories("com.carrefour.delivery.repos")
@EnableTransactionManagement
public class DomainConfig {
}
