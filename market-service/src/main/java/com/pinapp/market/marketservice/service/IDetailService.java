package com.pinapp.market.marketservice.service;

import com.pinapp.market.marketservice.controller.request.DetailRequest;
import com.pinapp.market.marketservice.domain.entity.Detail;

public interface IDetailService {


    Detail createDetail(DetailRequest detailRequest);

    Detail getDetail(Long id);

    Boolean editDetail(Long id, DetailRequest detailRequest);

}
