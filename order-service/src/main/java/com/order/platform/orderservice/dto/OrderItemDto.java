package com.order.platform.orderservice.dto;

import java.math.BigDecimal;

/**
 * author: user,
 * date: 21.06.2026
 */
public record OrderItemDto(
        Long id,
        Long itemId,
        Integer quantity,
        BigDecimal priceAtPurchase
) {
}
