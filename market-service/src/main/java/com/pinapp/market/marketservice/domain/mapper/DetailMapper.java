package com.pinapp.market.marketservice.domain.mapper;


import com.pinapp.market.marketservice.controller.request.DetailRequest;
import com.pinapp.market.marketservice.domain.model.Detail;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DetailMapper implements Function<DetailRequest, Detail> {


    @Override
    public Detail apply(DetailRequest detailRequest) {
        return Detail.builder()
                .item(detailRequest.getItem())
                .sku(detailRequest.getSku())
                .price(detailRequest.getPrice())
                .amount(detailRequest.getAmount())
                .subtotal(detailRequest.getPrice().multiply(detailRequest.getAmount()))
                .discount(detailRequest.getDiscount())
                .build();
    }
}
