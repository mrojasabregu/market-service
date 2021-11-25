package com.pinapp.market.marketservice.controller.response;

import com.pinapp.market.marketservice.domain.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SaleNoteResponse {

    private Long id;
    private Long orderNumber;
    private Date date;
    private CustomerResponse client;
    private AddressResponse address;
    private BigDecimal total;
    private List<DetailResponse> details;

}
