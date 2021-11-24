package com.pinapp.market.marketservice.service;

import com.pinapp.market.marketservice.controller.request.DetailRequest;
import com.pinapp.market.marketservice.domain.model.Detail;

import java.util.List;

public interface IDetailService {


    void createDetail(DetailRequest detailRequest, Long saleNoteId);

    Detail getDetail(Long id);

    Boolean editDetail(Long id, DetailRequest detailRequest);

    String deleteDetail(Long idSaleNote, Long idDetail);
}
