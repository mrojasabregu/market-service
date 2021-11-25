package com.pinapp.market.marketservice.service;

import com.pinapp.market.marketservice.controller.request.SaleNoteRequest;
import com.pinapp.market.marketservice.controller.response.SaleNoteResponse;
import com.pinapp.market.marketservice.domain.entity.SaleNote;


import java.util.List;

public interface ISaleNoteService {

    SaleNoteResponse createSaleNote(SaleNoteRequest orderRequest);

    SaleNoteResponse getSaleNote(Long id);

    Boolean editSaleNote(Long id, SaleNoteRequest saleNoteRequest);

    List<SaleNoteResponse> getsSaleNotesInProcess();

    List<SaleNoteResponse> getSaleNoteCanceled();

    Boolean saleNoteCancelled(Long id);

    void saleNoteCheckout(Long id);
}
