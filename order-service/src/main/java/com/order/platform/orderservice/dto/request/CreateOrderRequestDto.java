package com.order.platform.orderservice.dto.request;

import java.util.Set;

/**
 * author: user,
 * date: 30.06.2026
 */

public record CreateOrderRequestDto(
        Long customerId,
        String address,
        Set<OrderItemRequestDto> items
) {
}