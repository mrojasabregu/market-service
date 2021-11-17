package com.pinapp.market.marketservice.service.impl;

import com.pinapp.market.marketservice.controller.request.OrderRequest;
import com.pinapp.market.marketservice.domain.mapper.OrderMapper;
import com.pinapp.market.marketservice.domain.model.SaleNote;
import com.pinapp.market.marketservice.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    public SaleNote createOrder(OrderRequest orderRequest){

        SaleNote order = orderMapper.apply(orderRequest);

        return order;
    }
}
