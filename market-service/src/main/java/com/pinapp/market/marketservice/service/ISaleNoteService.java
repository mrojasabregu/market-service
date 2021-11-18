package com.pinapp.market.marketservice.service;

import com.pinapp.market.marketservice.controller.request.OrderRequest;
import com.pinapp.market.marketservice.domain.model.SaleNote;

public interface ISaleNoteService {

    SaleNote createSaleNote(OrderRequest orderRequest);

    SaleNote getOrder(Long id);
}
