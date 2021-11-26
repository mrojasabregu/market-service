package com.pinapp.market.marketservice.domain.mapper;

import com.pinapp.market.marketservice.controller.response.ProductResponse;
import com.pinapp.market.marketservice.domain.model.Product;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductResponseMapper implements Function<Product, ProductResponse> {

    public ProductResponse apply(Product product) {
        return ProductResponse.builder()
                .name(product.getName())
                .description(product.getDescription())
                .brand(product.getBrand())
                .build();
    }
}
