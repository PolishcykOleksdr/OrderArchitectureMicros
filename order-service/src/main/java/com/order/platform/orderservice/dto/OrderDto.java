package com.order.platform.orderservice.dto;

import com.order.platform.orderservice.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.Set;

/**
 * author: user,
 * date: 21.06.2026
 */

public record OrderDto(
        Long id,
        Long customerId,
        String address,
        BigDecimal totalAmount,
        String courierName,
        Integer etaMinutes,
        OrderStatus orderStatus,
        Set<OrderItemDto> orderItemDtos
) {
}