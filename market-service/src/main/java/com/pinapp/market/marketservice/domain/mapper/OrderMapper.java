package com.pinapp.market.marketservice.domain.mapper;

import com.pinapp.market.marketservice.controller.request.OrderRequest;
import com.pinapp.market.marketservice.domain.model.SaleNote;

import java.util.function.Function;

public class OrderMapper implements Function<OrderRequest, SaleNote> {

    public SaleNote apply(OrderRequest orderRequest){
        return SaleNote.builder()
                .id(orderRequest.getId())
                .orderNumber(orderRequest.getOrderNumber())
                .date(orderRequest.getDate())
                .state(orderRequest.getState())
               // .idCliente(orderRequest.getIdCliente())
               // .idAddress(orderRequest.getIdAddress())
                //.details(orderRequest.getDetails())
                .build();
    }

}
