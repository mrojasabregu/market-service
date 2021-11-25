package com.pinapp.market.marketservice.domain.mapper;

import com.pinapp.market.marketservice.controller.response.DetailResponse;
import com.pinapp.market.marketservice.domain.entity.Detail;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DetailResponseMapper implements Function<Detail, DetailResponse> {


    @Override
    public DetailResponse apply(Detail detail) {
        return DetailResponse.builder()
                .id(detail.getId())
                .item(detail.getItem())
                .sku(detail.getSku())
                .descripcion(detail.getProduct().toString())
                .price(detail.getPrice())
                .amount(detail.getAmount())
                .subtotal(detail.getSubtotal())
                .discount(detail.getDiscount())
                .build();
    }
}
