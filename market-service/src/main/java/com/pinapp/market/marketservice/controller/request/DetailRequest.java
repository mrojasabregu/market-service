
package com.pinapp.market.marketservice.controller.request;

import com.pinapp.market.marketservice.domain.model.SaleNote;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class DetailRequest {

    private Long id;
    private Integer item;
    private String sku;
    private Float price;
    private Double amount;
    private String discount;
    private SaleNote saleNote;

}