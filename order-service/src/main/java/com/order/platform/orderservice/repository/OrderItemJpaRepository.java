package com.order.platform.orderservice.repository;

import com.order.platform.orderservice.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: user,
 * date: 21.06.2026
 */
public interface OrderItemJpaRepository extends JpaRepository<OrderItemEntity, Long> {
}
