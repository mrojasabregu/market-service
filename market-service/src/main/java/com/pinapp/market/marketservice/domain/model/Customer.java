package com.pinapp.market.marketservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Customer {
    private String id;
    private String name;
    private String lastName;
    private String type;
    private String documentNumber;
    private String email;
    private String phone;


}
