package com.pinapp.market.marketservice.service;

import com.pinapp.market.marketservice.controller.request.SaleNoteRequest;
import com.pinapp.market.marketservice.domain.entity.SaleNote;

import java.util.List;

public interface ISaleNoteService {

    SaleNote createSaleNote(SaleNoteRequest orderRequest);

    SaleNote getSaleNote(Long id);

    Boolean editSaleNote(Long id, SaleNoteRequest saleNoteRequest);

    List<SaleNote> getsSaleNotesInProcess();

    List<SaleNote> getSaleNoteCanceled();

    Boolean saleNoteCancelled(Long id);

    void saleNoteIssued(Long id);
}
