package com.pinapp.market.marketservice.client;

import com.pinapp.market.marketservice.controller.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "customer-service", url = "http://localhost:8085")
public interface CustomerClient {

    @GetMapping("/customer")
    public CustomerResponse getCustomerByDocument(@SpringQueryMap Map<String, String> queryParameters);

}
