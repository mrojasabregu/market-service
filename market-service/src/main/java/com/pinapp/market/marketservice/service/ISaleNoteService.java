package com.pinapp.market.marketservice.service;

import com.pinapp.market.marketservice.controller.request.SaleNoteRequest;
import com.pinapp.market.marketservice.domain.model.SaleNote;

import java.util.List;

public interface ISaleNoteService {

    SaleNote createSaleNote(SaleNoteRequest orderRequest);

    SaleNote getSaleNote(Long id);

    SaleNote editSaleNote(Long id, SaleNoteRequest saleNoteRequest);

    List<SaleNote> getsSaleNotes();
}
