package com.pinapp.market.marketservice.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {


    @JsonBackReference
    private String sku;
    private String name;
    private String description;
    private Double price;
    private Integer unitAvailable;
    private String category;
    private String brand;

}
