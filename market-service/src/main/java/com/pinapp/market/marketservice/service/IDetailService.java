package com.pinapp.market.marketservice.service;

import com.pinapp.market.marketservice.controller.request.DetailRequest;
import com.pinapp.market.marketservice.controller.response.DetailResponse;
import com.pinapp.market.marketservice.controller.response.SaleNoteResponse;
import java.util.List;
import com.pinapp.market.marketservice.domain.entity.Detail;

public interface IDetailService {

    SaleNoteResponse createDetail(DetailRequest detailRequest, Long saleNoteId);

    DetailResponse getDetail(Long id);

    Boolean editDetail(Long id, DetailRequest detailRequest);

    String deleteDetail(Long idSaleNote, Long idDetail);
}
