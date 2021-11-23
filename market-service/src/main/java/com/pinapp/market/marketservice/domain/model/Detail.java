package com.pinapp.market.marketservice.domain.model;

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
    @Column(name = "DETAIL_ID")
    private Long id;
    private Integer item;
    private String sku;
    private BigDecimal price;
    private BigDecimal amount;
    private BigDecimal subtotal;
    private String discount;

}
