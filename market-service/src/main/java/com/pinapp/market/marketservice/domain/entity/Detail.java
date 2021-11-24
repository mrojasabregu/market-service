package com.pinapp.market.marketservice.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pinapp.market.marketservice.domain.entity.SaleNote;
import com.pinapp.market.marketservice.domain.model.Product;
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

    @Transient
    private Product product;

    private String discount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SALE_NOTE_ID")
    @JsonBackReference("details")
    private SaleNote saleNote;

}
