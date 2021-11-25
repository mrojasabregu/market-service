package com.pinapp.market.marketservice.controller.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DetailResponse {

    private Long id;
    private Integer item;
    private String sku;
    private BigDecimal price;
    private String descripcion;
    private String name;
    private BigDecimal amount;
    private BigDecimal subtotal;
    private String discount;


    public String toString(){
        return descripcion + " " + name;
    }

}
