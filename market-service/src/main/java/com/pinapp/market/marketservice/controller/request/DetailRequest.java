
package com.pinapp.market.marketservice.controller.request;

import com.pinapp.market.marketservice.domain.entity.SaleNote;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
public class DetailRequest {

    private Long id;
    private Integer item;
    private String sku;
    private BigDecimal price;
    private BigDecimal amount;
    private String discount;
    private SaleNote saleNote;

}