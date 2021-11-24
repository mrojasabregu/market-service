package com.pinapp.market.marketservice.domain.mapper;

import com.pinapp.market.marketservice.controller.response.SaleNoteResponse;
import com.pinapp.market.marketservice.domain.model.SaleNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class SaleNoteResponseMapper implements Function<SaleNote, SaleNoteResponse> {

    @Autowired
    private DetailResponseMapper detailResponseMapper;

    @Override
    public SaleNoteResponse apply(SaleNote saleNote) {
        return SaleNoteResponse.builder()
                .id(saleNote.getId())
                .orderNumber(saleNote.getOrderNumber())
                .date(saleNote.getDate())
                .state(saleNote.getState())
                .documentNumber(saleNote.getDocumentNumber())
                .documentType(saleNote.getDocumentType())
                .idAddress(saleNote.getIdAddress())
                .details(saleNote.getDetails().stream().map(detailResponseMapper).collect(Collectors.toList()))
                .total(saleNote.getTotal())
                .build();
    }
}
