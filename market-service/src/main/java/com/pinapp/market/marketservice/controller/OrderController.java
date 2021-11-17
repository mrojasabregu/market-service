package com.pinapp.market.marketservice.controller;


import com.pinapp.market.marketservice.controller.request.OrderDetailRequest;
import com.pinapp.market.marketservice.domain.mapper.OrderDetailMapper;
import com.pinapp.market.marketservice.domain.model.OrderDetail;
import com.pinapp.market.marketservice.service.impl.OrderDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    private OrderDetailServiceImpl orderDetailService;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @PostMapping(path = "/idOrder/detail")
    public OrderDetail createDetail(@Validated @RequestBody OrderDetailRequest orderDetailrequest) {
        return orderDetailService.createOrderDetail( orderDetailrequest );
    }

    @GetMapping(path = "/idOrder/detail/{id}")
    public OrderDetail retriveDetail(@PathVariable("id") Long id) {
        return orderDetailService.getOrderDetail(id);
    }
    
}
