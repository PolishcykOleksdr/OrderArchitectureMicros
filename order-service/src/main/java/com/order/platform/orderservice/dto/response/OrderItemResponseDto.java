package com.order.platform.orderservice.dto.response;

import java.math.BigDecimal;

/**
 * author: user,
 * date: 21.06.2026
 */
public record OrderItemResponseDto(
        Long id,
        Long itemId,
        Integer quantity,
        BigDecimal priceAtPurchase
) {
}
