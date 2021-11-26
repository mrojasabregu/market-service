package com.pinapp.market.marketservice.controller.request;

import com.pinapp.market.marketservice.domain.entity.Detail;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Builder
@Data
public class SaleNoteRequest {

    private Long id;
    private Long orderNumber;
    private Date date;
    private String documentNumber;
    private String documentType;
    private String idAddress;
    private BigDecimal total;
    private List<Detail> details;

}
