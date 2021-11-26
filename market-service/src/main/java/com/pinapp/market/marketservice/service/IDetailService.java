package com.pinapp.market.marketservice.service;

import com.pinapp.market.marketservice.controller.request.DetailRequest;
import com.pinapp.market.marketservice.domain.entity.Detail;

public interface IDetailService {


    void createDetail(DetailRequest detailRequest, Long saleNoteId);

    Detail getDetail(Long id);

    Boolean editDetail(Long id, DetailRequest detailRequest);

    Boolean deleteDetail(Long idSaleNote, Long idDetail);
}
