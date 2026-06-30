package com.order.platform.orderservice.dto.request;

/**
 * author: user,
 * date: 30.06.2026
 */
public record OrderItemRequestDto(
        Long itemId,
        Integer quantity,
        String name
) {
}
