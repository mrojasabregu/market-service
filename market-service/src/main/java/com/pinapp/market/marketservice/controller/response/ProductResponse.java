package com.pinapp.market.marketservice.controller.response;

import com.pinapp.market.marketservice.domain.model.Keyword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductResponse {


    private String sku;
    private String name;
    private String description;
    private Double price;
    private Integer unitAvailable;
    private String category;
    private String brand;
    private Integer amountToReserve;
    private Integer amountToCancel;

}
