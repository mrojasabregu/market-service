package com.pinapp.market.marketservice.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerResponse {

    private String name;
    private String lastName;
    private String type;
    private String documentNumber;
    private String email;
    private String phone;
}
