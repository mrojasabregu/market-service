package com.pinapp.market.marketservice.controller;


import com.pinapp.market.marketservice.config.exception.NumberFormatException;
import com.pinapp.market.marketservice.controller.request.DetailRequest;
import com.pinapp.market.marketservice.controller.request.SaleNoteRequest;
import com.pinapp.market.marketservice.domain.model.SaleNote;
import com.pinapp.market.marketservice.domain.model.Detail;
import com.pinapp.market.marketservice.service.IDetailService;
import com.pinapp.market.marketservice.service.ISaleNoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // acceso desde distintos origenes

@RestController
@RequestMapping(path = "/saleNote")
public class SaleNoteController {

    @Autowired
    private IDetailService detailService;

    @Autowired
    private ISaleNoteService saleNoteService;


    @Operation(summary = "Devuelve el detalle de compra de un item del pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Detail.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Detail not found",
                    content = @Content) })
    @GetMapping(path = "/detail/{id}")
    public Detail retrieveDetail(@PathVariable("id") Long id) {
        return detailService.getDetail(id);
    }

    @Operation (summary = "Genera un detalle de compra en el pedido")
    @PostMapping(path = "/detail")
    public Detail createDetail(@Validated @RequestBody DetailRequest detailrequest) {
        return detailService.createDetail(detailrequest);
    }

    @Operation (summary = "Cambia un valor en el detalle de compra del pedido")
    @PutMapping(path = "/detail/{id}")
    public Boolean editDetail(@PathVariable("id") Long id, @RequestBody DetailRequest detailRequest) {
        return detailService.editDetail(id, detailRequest);
    }


    @PostMapping(path = "/")
    public SaleNote crearSaleNote(@RequestBody SaleNoteRequest saleNoteRequest) {
        return saleNoteService.createSaleNote(saleNoteRequest);
    }

    @GetMapping(path = "/{id}")
    public SaleNote retriveSaleNote(@PathVariable("id") Long id) {
        return saleNoteService.getSaleNote(id);
    }

    @PutMapping(path = "/{id}")
    public Boolean editSaleNote(@PathVariable("id") Long id, @RequestBody SaleNoteRequest saleNoteRequest) {
        return saleNoteService.editSaleNote(id, saleNoteRequest);
    }

    @GetMapping
    public List<SaleNote> getSaleNotes() {
        return saleNoteService.getsSaleNotesInProcess();
    }

    @GetMapping(path = "/cancelled")
    public List<SaleNote> getSaleNotesAnulados() {
        return saleNoteService.getSaleNoteCanceled();
    }

    @GetMapping(path = "/{id}/cancel")
    public Boolean saleNoteCancelled(@PathVariable("id") Long id) {
        return saleNoteService.saleNoteCancelled(id);
    }

    @GetMapping(path = "/{id}/issue")
    public void saleNoteIssued(@PathVariable("id") Long id) {
        saleNoteService.saleNoteIssued(id);
    }


}
