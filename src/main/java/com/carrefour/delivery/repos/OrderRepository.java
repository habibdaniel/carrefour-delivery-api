package com.carrefour.delivery.repos;

import com.carrefour.delivery.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {

    boolean existsByReferenceIgnoreCase(String reference);

}
