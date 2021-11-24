package com.pinapp.market.marketservice.controller.response;

import com.pinapp.market.marketservice.domain.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerResponse {

    private String idCustomer;
    private String name;
    private String lastName;
    private String type;
    private String documentNumber;
    private String email;
    private String phone;
    private List<AddressResponse> addresses;
}
