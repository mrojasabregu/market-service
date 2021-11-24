package com.pinapp.market.marketservice.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AddressResponse {
    private String idAddress;
    private String city;
    private String street;
    private Long streetNumber;
    private Long floor;
    private String flat;
    private String idCustomer;

}
