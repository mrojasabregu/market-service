package com.pinapp.market.marketservice.service;

import com.pinapp.market.marketservice.controller.request.DetailRequest;
import com.pinapp.market.marketservice.controller.response.DetailResponse;
import com.pinapp.market.marketservice.domain.model.Detail;

import java.util.List;

public interface IDetailService {


    Detail createDetail(DetailRequest detailRequest);

    DetailResponse getDetail(Long id);

    Boolean editDetail(Long id, DetailRequest detailRequest);

}
