package com.order.platform.orderservice.mapper;

import com.order.platform.orderservice.dto.OrderDto;
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
    OrderEntity toEntity(OrderDto order);

    @AfterMapping
    default void linkOrderItemEntities(@MappingTarget OrderEntity orderEntity) {
        orderEntity.getOrderItems().forEach(orderItemEntity -> orderItemEntity.setOrder(orderEntity));
    }

    OrderDto toOrderDto(OrderEntity orderEntity);
}