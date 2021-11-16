package com.pinapp.market.marketservice.service;

import com.pinapp.market.marketservice.controller.request.OrderDetailRequest;
import com.pinapp.market.marketservice.domain.model.OrderDetail;

public interface IOrderDetailService {


    OrderDetail createOrderDetail(OrderDetailRequest orderDetailRequest);


}
