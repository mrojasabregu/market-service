package com.pinapp.market.marketservice.domain.model;

import lombok.*;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "SALE_NOTE_ID")
    private List<Detail> details;
    private BigDecimal total;

}
