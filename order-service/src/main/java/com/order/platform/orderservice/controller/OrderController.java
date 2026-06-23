package com.order.platform.orderservice.controller;

import com.order.platform.orderservice.entity.OrderItemEntity;
import com.order.platform.orderservice.repository.OrderJpaRepository;
import com.order.platform.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: user,
 * date: 23.06.2026
 */

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping()
    public OrderItemEntity create(
            @RequestBody OrderItemEntity orderItemEntity
    ) {
        return orderService.create(orderItemEntity);
    }
}