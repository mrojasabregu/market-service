package com.pinapp.market.marketservice.domain.entity;

import com.pinapp.market.marketservice.controller.response.CustomerResponse;
import com.pinapp.market.marketservice.domain.model.Address;
import com.pinapp.market.marketservice.domain.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "SALE_NOTE")
public class SaleNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SALE_NOTE_ID")
    private Long id;
    private Long orderNumber;
    private Date date;
    private String state;

    @Transient
    private CustomerResponse customer;

    @Transient
    private Address address;

    private String documentNumber;
    private String documentType;
    private Long idAddress;
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "SALE_NOTE_ID")
    private List<Detail> details;
    private BigDecimal total;

}
