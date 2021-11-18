package com.pinapp.market.marketservice.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.pinapp.market.marketservice.controller.request.SaleNoteRequest;
import com.pinapp.market.marketservice.domain.mapper.SaleNoteMapper;
import com.pinapp.market.marketservice.domain.model.SaleNote;
import com.pinapp.market.marketservice.repository.SaleNoteRepository;
import com.pinapp.market.marketservice.service.ISaleNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
        }else{
            return null;
        }
    }

    public SaleNote createSaleNote(SaleNoteRequest saleNoteRequest){

        SaleNote saleNoteNew = null;
        SaleNote saleNote = saleNoteMapper.apply(saleNoteRequest);
        saleNoteNew = saleNote;
        saleNoteNew.setDetails(null);
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
            return "Se actualizo con exito";
        }

        return "El objeto no se actualizo correctamente (NULL)";
    }

    public Iterable<SaleNote> getsSaleNotes(){
        return saleNoteRepository.findAll();
    }
}
