package com.order.platform.orderservice.service;

import com.order.platform.orderservice.dto.request.CreateOrderRequestDto;
import com.order.platform.orderservice.entity.OrderEntity;
import com.order.platform.orderservice.entity.OrderItemEntity;
import com.order.platform.orderservice.enums.OrderStatus;
import com.order.platform.orderservice.mapper.OrderEntityMapper;
import com.order.platform.orderservice.repository.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

/**
 * author: user,
 * date: 23.06.2026
 */

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderJpaRepository orderRepository;
    private final OrderEntityMapper orderEntityMapper;

    public OrderEntity create(CreateOrderRequestDto requestDto) {
        var entity = orderEntityMapper.toEntity(requestDto);
        calculatePricingForOrder(entity);
        entity.setStatus(OrderStatus.PENDING_PAYMENT);
        return orderRepository.save(entity);
    }

    private void calculatePricingForOrder(OrderEntity entity) {
        // Temporary (will be changed in the future to item prices)
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (OrderItemEntity item : entity.getItems()) {
            var randPrice = ThreadLocalRandom.current().nextDouble(100, 500);
            item.setPriceAtPurchase(BigDecimal.valueOf(randPrice));

            totalPrice = item
                    .getPriceAtPurchase()
                    .multiply(BigDecimal.valueOf(item.getQuantity()))
                    .add(totalPrice);
        }
        entity.setTotalAmount(totalPrice);
    }

    public OrderEntity getOrderOrThrow(Long id){
        var orderEntityOpt = orderRepository.findById(id);

        return orderEntityOpt
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Entity with id %d not found", id)
                )
        );
    }
}