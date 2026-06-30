package com.order.platform.orderservice.controller;

import com.order.platform.orderservice.dto.response.OrderResponseDto;
import com.order.platform.orderservice.dto.request.CreateOrderRequestDto;
import com.order.platform.orderservice.mapper.OrderEntityMapper;
import com.order.platform.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping("/create")
    public OrderResponseDto create(
            @RequestBody CreateOrderRequestDto requestDto
    ) {
        log.info("Creating order: request - {}", requestDto);
        var createdEntity = orderService.create(requestDto);
        return orderMapper.toOrderDto(createdEntity);
    }

    @GetMapping("/{id}")
    public OrderResponseDto getOrder(
            @PathVariable Long id
    ) {
        log.info("Getting order with id {}", id);
        var foundEntity = orderService.getOrderOrThrow(id);
        return orderMapper.toOrderDto(foundEntity);
    }
}