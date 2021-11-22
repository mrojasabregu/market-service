package com.pinapp.market.marketservice.controller;


import com.pinapp.market.marketservice.controller.request.DetailRequest;
import com.pinapp.market.marketservice.controller.request.SaleNoteRequest;
import com.pinapp.market.marketservice.domain.model.SaleNote;
import com.pinapp.market.marketservice.domain.model.Detail;
import com.pinapp.market.marketservice.service.IDetailService;
import com.pinapp.market.marketservice.service.ISaleNoteService;
import io.swagger.v3.oas.annotations.Operation;
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


    @Operation (summary = "Devuelve el detalle de compra de un item del pedido")
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
    public String editDetail(@PathVariable("id") Long id, @RequestBody DetailRequest detailRequest) {
        return detailService.editDetail(id, detailRequest);
    }


    //DELETE /pedido/{idPedido}/detalle/{idDetalle}
    @Operation( summary = "Elimina un detalle de un pedido determinado")
    @DeleteMapping(path = "/{idSaleNote}/detail/{idDetail}")
    public String deleteDetail(@PathVariable Long idSaleNote, @PathVariable Long idDetail) {
        return this.detailService.deleteDetail(idSaleNote, idDetail);
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
    public String editSaleNote(@PathVariable("id") Long id, @RequestBody SaleNoteRequest saleNoteRequest) {
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

    @PutMapping(path = "/{id}/cancel")
    public String saleNoteCancelled(@PathVariable("id") Long id, @RequestBody SaleNoteRequest saleNoteRequest) {
        return saleNoteService.saleNoteCancelled(id, saleNoteRequest);
    }

    @PutMapping(path = "/{id}/issue")
    public void saleNoteIssued(@PathVariable("id") Long id, @RequestBody SaleNoteRequest saleNoteRequest) {
        saleNoteService.saleNoteIssued(id, saleNoteRequest);
    }


}
