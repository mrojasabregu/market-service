package com.pinapp.market.marketservice.controller.request;

import com.pinapp.market.marketservice.domain.model.Address;
import com.pinapp.market.marketservice.domain.model.Client;
import com.pinapp.market.marketservice.domain.model.SaleNoteDetail;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@Data
public class OrderRequest {

    private Long id;
    private Long orderNumber;
    private Date date;
    private String state;
    private Client idCliente;
    private Address idAddress;
    private List<SaleNoteDetail> details;

}
