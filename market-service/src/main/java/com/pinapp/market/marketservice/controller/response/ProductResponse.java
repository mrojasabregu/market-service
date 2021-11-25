package com.pinapp.market.marketservice.controller.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductResponse {

    private String name;
    private String description;
    @JsonBackReference
    private Double price;
    private Integer unitAvailable;
    private String brand;

}
