package com.pinapp.market.marketservice.client;

import com.pinapp.market.marketservice.domain.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "product-service", url = "http://34.134.13.53")
public interface ProductClient {

    @GetMapping(path = "/product/{sku}")
    public ResponseEntity<Product> retriveProduct(@PathVariable("sku") String sku);

}
