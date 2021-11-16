package com.pinapp.market.marketservice.service;

import com.pinapp.market.marketservice.controller.request.OrderRequest;
import com.pinapp.market.marketservice.domain.model.Order;

public interface IOrderService {

    Order createOrder(OrderRequest orderRequest);
}
