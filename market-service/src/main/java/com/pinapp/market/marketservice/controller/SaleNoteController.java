package com.pinapp.market.marketservice.controller;


import com.pinapp.market.marketservice.controller.request.OrderDetailRequest;
import com.pinapp.market.marketservice.controller.request.SaleNoteRequest;
import com.pinapp.market.marketservice.domain.model.SaleNote;
import com.pinapp.market.marketservice.domain.model.SaleNoteDetail;
import com.pinapp.market.marketservice.service.IOrderDetailService;
import com.pinapp.market.marketservice.service.ISaleNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/saleNote")
public class SaleNoteController {

    @Autowired
    private IOrderDetailService orderDetailService;

    @Autowired
    private ISaleNoteService saleNoteService;

    @PostMapping(path = "/idSaleNote/detail")
    public SaleNoteDetail createDetail(@Validated @RequestBody OrderDetailRequest orderDetailrequest) {
        return orderDetailService.createOrderDetail( orderDetailrequest );
    }

    @GetMapping(path = "/idSaleNote/detail/{id}")
    public SaleNoteDetail retriveDetail(@PathVariable("id") Long id) {
        return orderDetailService.getOrderDetail(id);
    }

    @PostMapping(path = "/")
    public SaleNote crearSaleNote(@RequestBody SaleNoteRequest saleNoteRequest){
        return saleNoteService.createSaleNote(saleNoteRequest);
    }

    @GetMapping(path = "/{id}")
    public SaleNote retriveSaleNote(@PathVariable("id") Long id){
        return saleNoteService.getSaleNote(id);
    }

    @PutMapping(path = "/{id}")
    public String editSaleNote(@PathVariable("id") Long id, @RequestBody SaleNoteRequest saleNoteRequest){
        return saleNoteService.editSaleNote(id, saleNoteRequest);
    }

    @GetMapping
    public Iterable<SaleNote> getSaleNotes(){
        return saleNoteService.getsSaleNotes();
    }
}
