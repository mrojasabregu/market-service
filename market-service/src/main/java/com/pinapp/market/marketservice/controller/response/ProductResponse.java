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
    List<Keyword> keywords = new ArrayList<>();
}
