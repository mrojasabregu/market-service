package com.pinapp.market.marketservice.domain.mapper;


import com.pinapp.market.marketservice.controller.request.DetailRequest;
import com.pinapp.market.marketservice.domain.entity.Detail;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DetailRequestMapper implements Function<DetailRequest, Detail> {


    @Override
    public Detail apply(DetailRequest detailRequest) {
        return Detail.builder()
                .id(detailRequest.getId())
                .item(detailRequest.getItem())
                .sku(detailRequest.getSku())
                .price(detailRequest.getPrice())
                .amount(detailRequest.getAmount())
                .discount(detailRequest.getDiscount())
                .saleNote(detailRequest.getSaleNote())
                .build();
    }
}
