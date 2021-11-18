package com.pinapp.market.marketservice.service.impl;

import java.util.List;
import java.util.Optional;

import com.pinapp.market.marketservice.controller.request.SaleNoteRequest;
import com.pinapp.market.marketservice.domain.mapper.SaleNoteMapper;
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
        Optional<SaleNote> saleNote =  saleNoteRepository.findById(id);
        if(saleNote.isPresent()){
            return saleNote.get();
        }
        return null;
    }

    public SaleNote createSaleNote(SaleNoteRequest saleNoteRequest){

        SaleNote saleNoteNew;
        SaleNote saleNote = saleNoteMapper.apply(saleNoteRequest);
        saleNoteNew = saleNote;
        saleNoteRepository.save(saleNoteNew);

        return  saleNoteNew;
    }

    public String editSaleNote(Long id, SaleNoteRequest saleNoteRequest){
        SaleNote saleNoteActu = null;
        Optional<SaleNote> saleNoteBD = saleNoteRepository.findById(id);
        if(saleNoteBD.isPresent()){
            saleNoteActu = saleNoteBD.get();
            saleNoteActu.setOrderNumber(saleNoteRequest.getOrderNumber());
            saleNoteActu.setDate(saleNoteRequest.getDate());
            saleNoteActu.setDocumentNumber(saleNoteRequest.getDocumentNumber());
            saleNoteActu.setDocumentType(saleNoteRequest.getDocumentType());
            saleNoteActu.setIdAddress(saleNoteRequest.getIdAddress());
        }
        if(saleNoteActu != null) {
            saleNoteRepository.save(saleNoteActu);
            log.info("Se actualizo con éxito");
            return "Se actualizo con éxito";
        }

        log.info("El objeto no se actualizo correctamente (NULL)");
        return "El objeto no se actualizo correctamente (NULL)";
    }

    public List<SaleNote> getsSaleNotesInProcess(){
        return saleNoteRepository.getState();
    }

    public List<SaleNote> getSaleNoteCanceled(){
        return saleNoteRepository.getStateCanceled();
    }

    public String changeState(Long id, SaleNoteRequest saleNoteRequest){
        SaleNote saleNoteActu = null;
        Optional<SaleNote> saleNoteBD = saleNoteRepository.findById(id);
        if(saleNoteBD.isPresent()) {
            saleNoteActu = saleNoteBD.get();
            saleNoteActu.setState("Canceled");
        }
        if(saleNoteActu != null) {
            saleNoteRepository.save(saleNoteActu);
            log.info("Se actualizo con éxito");
            return "Se actualizo con éxito";
        }

        log.info("El objeto no se actualizo correctamente (NULL)");
        return "El objeto no se actualizo correctamente (NULL)";
    }
}
