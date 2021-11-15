package com.pinapp.market.marketservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedido {
    private Long idDetalle;
    private Integer item;
    private Producto product;
    private Double amount;
    private int discount;
}
