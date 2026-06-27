package com.order.platform.orderservice.controller;

import com.order.platform.orderservice.dto.OrderDto;
import com.order.platform.orderservice.entity.OrderEntity;
import com.order.platform.orderservice.entity.OrderItemEntity;
import com.order.platform.orderservice.mapper.OrderEntityMapper;
import com.order.platform.orderservice.repository.OrderJpaRepository;
import com.order.platform.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * author: user,
 * date: 23.06.2026
 */

@Slf4j
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderEntityMapper orderMapper;

    @PostMapping()
    public OrderDto create(
            @RequestBody OrderEntity orderItemEntity
    ) {
        log.info("Creating order with id {}", orderItemEntity.getId());
        var createdEntity = orderService.create(orderItemEntity);
        return orderMapper.toOrderDto(createdEntity);
    }

    @GetMapping("/{id}")
    public OrderDto getOrder(
            @PathVariable Long id
    ) {
        log.info("Getting order with id {}", id);
        var foundEntity = orderService.getOrderOrThrow(id);
        return orderMapper.toOrderDto(foundEntity);
    }
}