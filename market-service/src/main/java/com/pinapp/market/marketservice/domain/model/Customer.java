package com.pinapp.market.marketservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Customer {

    private String name;
    private String lastName;
    private String documentType;
    private Long documentNumber;
    private String email;
    private Long phone;
    private Address address;


}
