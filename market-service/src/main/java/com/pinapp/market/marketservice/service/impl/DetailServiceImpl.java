package com.pinapp.market.marketservice.service.impl;

import com.pinapp.market.marketservice.config.exception.BadRequestException;
import com.pinapp.market.marketservice.config.exception.NotFoundException;
import com.pinapp.market.marketservice.controller.request.DetailRequest;
import com.pinapp.market.marketservice.domain.mapper.DetailMapper;
import com.pinapp.market.marketservice.domain.model.Detail;
import com.pinapp.market.marketservice.domain.model.SaleNote;
import com.pinapp.market.marketservice.repository.DetailRepository;
import com.pinapp.market.marketservice.repository.SaleNoteRepository;
import com.pinapp.market.marketservice.service.IDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class DetailServiceImpl implements IDetailService {


    @Autowired
    private DetailMapper detailMapper;

    @Autowired
    private DetailRepository detailRepository;

    @Autowired
    private SaleNoteRepository saleNoteRepository;


    public Detail getDetail(Long id) {
        Optional<Detail> detail = detailRepository.findById(id);
        if (detail.isPresent()) {
            log.info("Se mostro con éxito el DETALLE");
            return detail.get();
        }
        log.info("NO se pudo mostrar el DETALLE");
        throw new NotFoundException("Detail does not exist");
    }

    public Detail createDetail(DetailRequest detailRequest) {
        if(detailRequest.getSaleNote() == null){
            throw new BadRequestException("Invalid Sale Note");
        }
        Detail detailNew;
        Detail detail = detailMapper.apply(detailRequest);
        detailNew = detail;
        detailNew.setId(null);
        Optional<SaleNote> sale = saleNoteRepository.findById(detailRequest.getSaleNote().getId());
        detailNew.setSaleNote(sale.get());

        detailRepository.save(detailNew);
        log.info("Se cargo el DETALLE  con éxito");

        return detailNew;
    }

    public Boolean editDetail(Long id, DetailRequest detailRequest) {
        Detail detailActu = null;
        Optional<Detail> detailBD = detailRepository.findById(id);
        if (detailBD.isPresent()) {
            detailActu = detailBD.get();
            if (detailRequest.getItem() != null) {
                detailActu.setItem(detailRequest.getItem());
            }
            if (detailRequest.getSku() != null) {
                detailActu.setSku(detailRequest.getSku());
            }
            if (detailRequest.getPrice() != null) detailActu.setPrice(detailRequest.getPrice());
            if (detailRequest.getAmount() != null) detailActu.setAmount(detailRequest.getAmount());
            if (detailRequest.getDiscount() != null) detailActu.setDiscount(detailRequest.getDiscount());
            if (detailActu.getSaleNote() != null) detailActu.setSaleNote(detailRequest.getSaleNote());
        }
        if (detailActu != null) {
            detailRepository.save(detailActu);
            log.info("Se actualizo el DETALLE con éxito");
            return true;
        }

        log.info("El DETALLE no se actualizo correctamente (NULL)");
        return false;
    }

}
