package com.pinapp.market.marketservice.domain.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

    private Long productId;
    private String sku;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;
    private Integer unitAvailable;
    private Double weight;
    private String category;
    private String brand;
    private Integer amountToReserve;
    private Integer amountToCancel;

    public String toString(){
        return description + " " + brand;
    }

}
