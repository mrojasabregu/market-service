package com.pinapp.market.marketservice.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReserveProductRequest {

    @NotNull(message = "El campo amountToReserve no puede ser null o vacio.")
    @Min(value = 0, message = "The value must be positive")
    Integer amountToReserve;

}
