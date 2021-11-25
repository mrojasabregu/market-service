package com.pinapp.market.marketservice.client;

import com.pinapp.market.marketservice.controller.request.ReserveProductRequest;
import com.pinapp.market.marketservice.controller.response.ProductResponse;
import com.pinapp.market.marketservice.controller.request.CancelReserveProductRequest;
import com.pinapp.market.marketservice.domain.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;


@FeignClient(name = "product-service", url = "http://localhost:8085")
public interface ProductClient {

    @GetMapping(path = "/product/{sku}")
    public ProductResponse retriveProduct(@PathVariable("sku") String sku);

    @PostMapping(path = "/product/{sku}/stock/reserve")
    public ResponseEntity<List<Product>> reserveProduct(@Validated @RequestBody ReserveProductRequest reserveProductRequest, @PathVariable("sku") String sku);

    @PostMapping(path = "/product/stock/cancelReserve")
    public String cancelProduct(@Validated @RequestBody List<CancelReserveProductRequest> cancelRequests);
}
