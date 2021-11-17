
package com.pinapp.market.marketservice.controller.request;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class OrderDetailRequest{

    private Long id;
    private Integer item;
//    private Product product;
    private Float price;
    private Double amount;
    private String discount;
}