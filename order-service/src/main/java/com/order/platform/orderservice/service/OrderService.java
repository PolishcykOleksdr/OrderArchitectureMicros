package com.order.platform.orderservice.service;

import com.order.platform.orderservice.entity.OrderEntity;
import com.order.platform.orderservice.entity.OrderItemEntity;
import com.order.platform.orderservice.repository.OrderItemJpaRepository;
import com.order.platform.orderservice.repository.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

/**
 * author: user,
 * date: 23.06.2026
 */

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderJpaRepository repository;

    public OrderEntity create(OrderEntity orderItemEntity) {
        return repository.save(orderItemEntity);
    }

    public OrderEntity getOrderOrThrow(Long id){
        var orderEntityOpt = repository.findById(id);

        return orderEntityOpt
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Entity with id %d not found", id)
                )
        );
    }
}