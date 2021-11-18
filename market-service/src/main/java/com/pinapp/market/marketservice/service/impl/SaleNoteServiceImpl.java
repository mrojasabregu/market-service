package com.pinapp.market.marketservice.service.impl;

import java.util.Optional;

import com.pinapp.market.marketservice.controller.request.OrderRequest;
import com.pinapp.market.marketservice.domain.mapper.OrderMapper;
import com.pinapp.market.marketservice.domain.model.SaleNote;
import com.pinapp.market.marketservice.repository.SaleNoteRepository;
import com.pinapp.market.marketservice.service.ISaleNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SaleNoteServiceImpl implements ISaleNoteService {

    @Autowired
    private OrderMapper orderMapper;

    private SaleNoteRepository orderRepository;




    public SaleNote getOrder(Long id){
        Optional<SaleNote> order =  orderRepository.findById(id);
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
