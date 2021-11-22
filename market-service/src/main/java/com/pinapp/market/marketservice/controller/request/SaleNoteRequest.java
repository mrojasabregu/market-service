package com.pinapp.market.marketservice.controller.request;

import com.pinapp.market.marketservice.domain.model.Detail;
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
    private String state;
    private String documentNumber;
    private String documentType;
    private Long idAddress;
    private BigDecimal total;
    private List<Detail> details;

}
