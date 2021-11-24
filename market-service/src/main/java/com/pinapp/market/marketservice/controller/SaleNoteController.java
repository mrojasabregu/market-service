package com.pinapp.market.marketservice.controller;


import com.pinapp.market.marketservice.config.exception.NumberFormatException;
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
    @GetMapping(path = "/detail/{idDetail}")
    public Detail retrieveDetail(@PathVariable("idDetail") Long idDetail) {
        return detailService.getDetail(idDetail);
    }

    @Operation (summary = "Genera un detalle de compra en el pedido")
    @PostMapping(path = "/{saleNoteId}/detail")
    public void createDetail(@Validated @RequestBody DetailRequest detailrequest,@PathVariable Long saleNoteId) {
        detailService.createDetail(detailrequest, saleNoteId);
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
