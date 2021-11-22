package com.pinapp.market.marketservice.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DETAIL")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer item;
    private String sku;
    private BigDecimal price;
    private BigDecimal amount;
    private BigDecimal subtotal;
    private String discount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SALE_NOTE_ID")
    @JsonBackReference("details")
    private SaleNote saleNote;

}
