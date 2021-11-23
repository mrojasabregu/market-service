package com.pinapp.market.marketservice.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.pinapp.market.marketservice.config.exception.BadRequestException;
import com.pinapp.market.marketservice.config.exception.NotFoundException;
import com.pinapp.market.marketservice.controller.request.SaleNoteRequest;
import com.pinapp.market.marketservice.domain.mapper.SaleNoteMapper;
import com.pinapp.market.marketservice.domain.model.Detail;
import com.pinapp.market.marketservice.domain.model.SaleNote;
import com.pinapp.market.marketservice.repository.SaleNoteRepository;
import com.pinapp.market.marketservice.service.ISaleNoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class SaleNoteServiceImpl implements ISaleNoteService {

    @Autowired
    private SaleNoteMapper saleNoteMapper;

    @Autowired
    private SaleNoteRepository saleNoteRepository;




    public SaleNote getSaleNote(Long id){
        if(id.getClass() != Long.class){
            throw new NumberFormatException("Invalid ID supplied");
        }
        Optional<SaleNote> saleNote =  saleNoteRepository.findById(id);
        if(saleNote.isPresent()){
            log.info("Se mostro con éxito el PEDIDO");
            return saleNote.get();
        }
        log.info("No se encontro el PEDIDO");
        throw new NotFoundException("Invalid ID");
    }

    public SaleNote createSaleNote(SaleNoteRequest saleNoteRequest){
        if(saleNoteRequest.getDate()  == null || saleNoteRequest.getDocumentNumber() == null || saleNoteRequest.getDocumentType() == null || saleNoteRequest.getIdAddress() == null ||  saleNoteRequest.getOrderNumber() == null){
            throw new BadRequestException("Invalid input");
        }
        SaleNote saleNoteNew;
        SaleNote saleNote = saleNoteMapper.apply(saleNoteRequest);
        saleNoteNew = saleNote;
        saleNoteNew.setState("INPROCESS");
        saleNoteRepository.save(saleNoteNew);

        return  saleNoteNew;
    }

    public Boolean editSaleNote(Long id, SaleNoteRequest saleNoteRequest){
        if(id.getClass() != Long.class){
            throw new NumberFormatException("Invalid ID");
        }
        SaleNote saleNoteActu = null;
        Optional<SaleNote> saleNoteBD = saleNoteRepository.findById(id);
        if(saleNoteBD.isPresent()){
            saleNoteActu = saleNoteBD.get();
            if(saleNoteRequest.getOrderNumber() != null){saleNoteActu.setOrderNumber(saleNoteRequest.getOrderNumber());}
            if(saleNoteRequest.getDate() != null){saleNoteActu.setDate(saleNoteRequest.getDate());}
            if(saleNoteRequest.getDocumentNumber() != null){saleNoteActu.setDocumentNumber(saleNoteRequest.getDocumentNumber());}
            if(saleNoteRequest.getDocumentType() != null){saleNoteActu.setDocumentType(saleNoteRequest.getDocumentType());}
            if(saleNoteRequest.getIdAddress() != null){saleNoteActu.setIdAddress(saleNoteRequest.getIdAddress());}
        }
        if(saleNoteActu != null) {
            saleNoteRepository.save(saleNoteActu);
            log.info("Se actualizo con éxito");
            return true;
        }

        log.info("El objeto no se actualizo correctamente (NULL)");
        throw new NotFoundException("SaleNote does not exist");
    }

    public List<SaleNote> getsSaleNotesInProcess(){
        return saleNoteRepository.getState();
    }

    public List<SaleNote> getSaleNoteCanceled(){
        return saleNoteRepository.getStateCanceled();
    }

    public Boolean saleNoteCancelled(Long id){
        if(id.getClass() != Long.class){
            throw new NumberFormatException("Invalid ID supplied");
        }
        SaleNote saleNoteActu = null;
        Optional<SaleNote> saleNoteBD = saleNoteRepository.findById(id);
        if(saleNoteBD.isPresent()) {
            saleNoteActu = saleNoteBD.get();
            saleNoteActu.setState("CANCELLED");
        }
        if(saleNoteActu != null) {
            saleNoteRepository.save(saleNoteActu);
            log.info("Se actualizo con éxito");
            return true;
        }

        log.info("El objeto no se actualizo correctamente (NULL)");
        throw new NotFoundException("SaleNote does not exist");
    }

    public void saleNoteIssued(Long id){
        if(id.getClass() != Long.class){
            throw new NumberFormatException("Invalid ID");
        }
        BigDecimal subtotal = BigDecimal.ZERO;
        SaleNote saleNoteActu = null;
        Optional<SaleNote> saleNoteBD = saleNoteRepository.findById(id);
        if(saleNoteBD.isPresent()) {
            saleNoteActu = saleNoteBD.get();
            if(saleNoteActu.getDetails().size() != 0){
                saleNoteActu.setState("ISSUED");
                for(Detail detail : saleNoteActu.getDetails()){
                    subtotal = subtotal.add(detail.getSubtotal());
                }
                saleNoteActu.setTotal(subtotal);

            }else{
                log.info("El pedido debe contener al menos un detalle para poder emitirse");
                log.error("El pedido no se pudo emitir");
                throw new BadRequestException("The list must contain at least 1 detail.");
            }
        }
        if(saleNoteActu != null) {
            saleNoteRepository.save(saleNoteActu);
            log.info("Se emitió el pedido con éxito");
        }else{
            log.error("El pedido no se pudo emitir");
            throw new NotFoundException("SaleNote does not exist");
        }
    }
}
