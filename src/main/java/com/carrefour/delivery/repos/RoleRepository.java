package com.carrefour.delivery.repos;

import com.carrefour.delivery.domain.Role;
import com.carrefour.delivery.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {

}
