package com.pinapp.market.marketservice.service.impl;

import com.pinapp.market.marketservice.controller.request.OrderDetailRequest;
import com.pinapp.market.marketservice.domain.mapper.OrderDetailMapper;
import com.pinapp.market.marketservice.domain.model.OrderDetail;
import com.pinapp.market.marketservice.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class OrderDetailServiceImpl implements IOrderDetailService {


    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public OrderDetail createOrderDetail(OrderDetailRequest orderDetailRequest) {

        OrderDetail order_detail= orderDetailMapper.apply(orderDetailRequest);

       // Optional<OrderDetail>

        return null;
    }
}
