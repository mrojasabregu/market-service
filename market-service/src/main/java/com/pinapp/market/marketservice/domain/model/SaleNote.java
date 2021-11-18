package com.pinapp.market.marketservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
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
    private String documentNumber;
    private String documentType;
    private Long idAddress;
    @OneToMany(mappedBy="saleNote", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Detail> details;

}
