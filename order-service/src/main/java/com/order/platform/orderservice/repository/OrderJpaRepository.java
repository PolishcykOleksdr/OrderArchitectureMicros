package com.order.platform.orderservice.repository;

import com.order.platform.orderservice.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: user,
 * date: 21.06.2026
 */
public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
}