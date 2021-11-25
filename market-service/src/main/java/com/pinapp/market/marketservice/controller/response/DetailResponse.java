package com.pinapp.market.marketservice.controller.response;

import com.pinapp.market.marketservice.domain.entity.SaleNote;
import com.pinapp.market.marketservice.domain.model.Product;
import feign.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DetailResponse {

    private Long id;
    private Integer item;
    private String sku;
    private BigDecimal price;
    private BigDecimal amount;
    private Product product;
    private BigDecimal subtotal;
    private String discount;

}
