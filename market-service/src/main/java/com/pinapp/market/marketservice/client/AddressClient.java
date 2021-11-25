package com.pinapp.market.marketservice.client;

import com.pinapp.market.marketservice.controller.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "address-service", url = "http://34.176.124.51")
public interface AddressClient {

    @GetMapping("/address/{idAddress}")
    public AddressResponse getIdAddressByCustomerId(@PathVariable(name = "idAddress") String idAddress);

}
