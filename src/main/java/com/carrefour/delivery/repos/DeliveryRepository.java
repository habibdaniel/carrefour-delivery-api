package com.carrefour.delivery.repos;

import com.carrefour.delivery.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
