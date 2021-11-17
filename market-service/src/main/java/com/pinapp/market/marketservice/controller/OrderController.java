package com.pinapp.market.marketservice.controller;


import com.pinapp.market.marketservice.controller.request.OrderDetailRequest;
import com.pinapp.market.marketservice.domain.model.SaleNoteDetail;
import com.pinapp.market.marketservice.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    private IOrderDetailService orderDetailService;

    @PostMapping(path = "/idOrder/detail")
    public SaleNoteDetail createDetail(@Validated @RequestBody OrderDetailRequest orderDetailrequest) {
        return orderDetailService.createOrderDetail( orderDetailrequest );
    }

    @GetMapping(path = "/idOrder/detail/{id}")
    public SaleNoteDetail retriveDetail(@PathVariable("id") Long id) {
        return orderDetailService.getOrderDetail(id);
    }
    
}
