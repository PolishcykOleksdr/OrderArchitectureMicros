package com.order.platform.orderservice.service;

import com.order.platform.orderservice.entity.OrderItemEntity;
import com.order.platform.orderservice.repository.OrderItemJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * author: user,
 * date: 23.06.2026
 */

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderItemJpaRepository repository;

    public OrderItemEntity create(OrderItemEntity orderItemEntity) {
        return repository.save(orderItemEntity);
    }
}