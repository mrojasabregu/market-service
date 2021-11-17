package com.pinapp.market.marketservice.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SaleNoteDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer item;
    private String sku;
    private Float price;
    private Double amount;
    private String discount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SALE_NOTE_ID")
    @JsonBackReference("details")
    private SaleNote saleNote;

}
