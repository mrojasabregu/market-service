package com.pinapp.market.marketservice.domain.mapper;

import com.pinapp.market.marketservice.controller.request.SaleNoteRequest;
import com.pinapp.market.marketservice.domain.model.SaleNote;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SaleNoteMapper implements Function<SaleNoteRequest, SaleNote> {

    public SaleNote apply(SaleNoteRequest saleNoteRequest){
        return SaleNote.builder()
                .id(saleNoteRequest.getId())
                .orderNumber(saleNoteRequest.getOrderNumber())
                .date(saleNoteRequest.getDate())
                .state(saleNoteRequest.getState())
                .documentNumber(saleNoteRequest.getDocumentNumber())
                .documentType(saleNoteRequest.getDocumentType())
                .idAddress(saleNoteRequest.getIdAddress())
                .details(saleNoteRequest.getDetails())
                .total(saleNoteRequest.getTotal())
                .build();
    }

}
