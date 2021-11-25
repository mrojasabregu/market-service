package com.pinapp.market.marketservice.controller;


import com.pinapp.market.marketservice.controller.request.DetailRequest;
import com.pinapp.market.marketservice.controller.request.SaleNoteRequest;
import com.pinapp.market.marketservice.controller.response.DetailResponse;
import com.pinapp.market.marketservice.controller.response.SaleNoteResponse;
import com.pinapp.market.marketservice.domain.entity.Detail;
import com.pinapp.market.marketservice.service.IDetailService;
import com.pinapp.market.marketservice.service.ISaleNoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @GetMapping(path = "/detail/{idDetail}")
    public DetailResponse retrieveDetail(@PathVariable("idDetail") Long idDetail) {
        return detailService.getDetail(idDetail);
    }


    @Operation (summary = "Genera un detalle de compra en el pedido")
    @PostMapping(path = "/{saleNoteId}/detail")
    public SaleNoteResponse createDetail(@Validated @RequestBody DetailRequest detailrequest,@PathVariable Long saleNoteId) {
        return detailService.createDetail(detailrequest, saleNoteId);
    }

    @Operation (summary = "Cambia un valor en el detalle de compra del pedido")
    @PutMapping(path = "/detail/{idDetail}")
    public Boolean editDetail(@PathVariable("idDetail") Long idDetail, @RequestBody DetailRequest detailRequest) {
        return detailService.editDetail(idDetail, detailRequest);
    }

    @Operation( summary = "Elimina un detalle de un pedido determinado")
    @DeleteMapping(path = "/{idSaleNote}/detail/{idDetail}")
    public String deleteDetail(@PathVariable Long idSaleNote, @PathVariable Long idDetail) {
        return this.detailService.deleteDetail(idSaleNote, idDetail);
    }

    @PostMapping(path = "/")
    public SaleNoteResponse crearSaleNote(@RequestBody SaleNoteRequest saleNoteRequest) {
        return saleNoteService.createSaleNote(saleNoteRequest);
    }

    @GetMapping(path = "/{id}")
    public SaleNoteResponse retriveSaleNote(@PathVariable("id") Long id) {
        return saleNoteService.getSaleNote(id);
    }

    @PutMapping(path = "/{id}")
    public Boolean editSaleNote(@PathVariable("id") Long id, @RequestBody SaleNoteRequest saleNoteRequest) {
        return saleNoteService.editSaleNote(id, saleNoteRequest);
    }

    @GetMapping
    public List<SaleNoteResponse> getSaleNotes() {
        return saleNoteService.getsSaleNotesInProcess();
    }

    @GetMapping(path = "/{idSaleNote}/cancel")
    public Boolean saleNoteCancelled(@PathVariable("id") Long id) {
        return saleNoteService.saleNoteCancelled(id);
    }

    @GetMapping(path = "/{idSaleNote}/checkout")
    public void saleNoteCheckout(@PathVariable("idSaleNote") Long idSaleNote) {
        saleNoteService.saleNoteCheckout(idSaleNote);
    }


}
