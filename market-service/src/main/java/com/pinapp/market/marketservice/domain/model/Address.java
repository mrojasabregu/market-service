package com.pinapp.market.marketservice.domain.model;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Address {

    private String idAddress;
    private String city;
    private String street;
    private Long streetNumber;
    private Long floor;
    private String flat;

}
