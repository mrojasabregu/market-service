package com.pinapp.market.marketservice.service.impl;

import java.util.Optional;

import com.pinapp.market.marketservice.controller.request.OrderRequest;
import com.pinapp.market.marketservice.domain.mapper.OrderMapper;
import com.pinapp.market.marketservice.domain.model.SaleNote;
import com.pinapp.market.marketservice.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import main.java.com.pinapp.market.marketservice.repository.OrderRepository;

public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;




    public SaleNote getOrder(Long id){
        Optional<SaleNote> order =  OrderRepository.findById(id);
        if(order.isPresent()){
            return order.get();
        }else{
            return null;
        }
    }
    public SaleNote createSaleNote(OrderRequest orderRequest){

        SaleNote order = orderMapper.apply(orderRequest);

        return order;
    }
}
