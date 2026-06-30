package com.order.platform.orderservice.mapper;

import com.order.platform.orderservice.dto.response.OrderResponseDto;
import com.order.platform.orderservice.dto.request.CreateOrderRequestDto;
import com.order.platform.orderservice.entity.OrderEntity;
import org.mapstruct.*;

/**
 * author: user,
 * date: 21.06.2026
 */

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface OrderEntityMapper {
    OrderEntity toEntity(CreateOrderRequestDto order);

    @AfterMapping
    default void linkOrderItemEntities(@MappingTarget OrderEntity orderEntity) {
        orderEntity.getItems().forEach(orderItemEntity -> orderItemEntity.setOrder(orderEntity));
    }

    OrderResponseDto toOrderDto(OrderEntity orderEntity);
}