package com.pinapp.market.marketservice.domain.mapper;


import com.pinapp.market.marketservice.controller.request.OrderDetailRequest;
import com.pinapp.market.marketservice.domain.model.OrderDetail;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class OrderDetailMapper implements Function< OrderDetailRequest, OrderDetail> {


    @Override
    public OrderDetail apply(OrderDetailRequest orderDetailRequest) {
        return OrderDetail.builder()
                .id(orderDetailRequest.getId())
                .item(orderDetailRequest.getItem())
                .product(orderDetailRequest.getProduct())
                .price(orderDetailRequest.getPrice())
                .amount(orderDetailRequest.getAmount())
                .discount(orderDetailRequest.getDiscount())
                .build();
    }
}
