package com.pinapp.market.marketservice.service;

import com.pinapp.market.marketservice.controller.request.OrderDetailRequest;
import com.pinapp.market.marketservice.domain.model.SaleNoteDetail;

public interface IOrderDetailService {


    SaleNoteDetail createOrderDetail(OrderDetailRequest orderDetailRequest);


    SaleNoteDetail getOrderDetail(Long id);
}
