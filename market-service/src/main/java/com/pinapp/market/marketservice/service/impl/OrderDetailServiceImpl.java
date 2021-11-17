package com.pinapp.market.marketservice.service.impl;

import com.pinapp.market.marketservice.controller.request.OrderDetailRequest;
import com.pinapp.market.marketservice.domain.mapper.OrderDetailMapper;
import com.pinapp.market.marketservice.domain.model.OrderDetail;
import com.pinapp.market.marketservice.repository.OrderDetailRepository;
import com.pinapp.market.marketservice.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {


    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDetail createOrderDetail(OrderDetailRequest orderDetailRequest) {

        OrderDetail order_detail= orderDetailMapper.apply(orderDetailRequest);

        Optional<OrderDetail> order_detail_db = orderDetailRepository.findById( order_detail.getIdOrderDetail());
        if( order_detail_db.isPresent() )
        {
           // orderDetailRepository.save()
        }

        return null;
    }

    public OrderDetail getOrderDetail(Long id) {
        Optional<OrderDetail> order_detail_op = orderDetailRepository.findById(id);
        if (order_detail_op.isPresent()) {
            return order_detail_op.get();
        } else {
            return null;
        }
    }


}
