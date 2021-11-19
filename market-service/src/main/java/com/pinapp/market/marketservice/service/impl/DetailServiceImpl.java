package com.pinapp.market.marketservice.service.impl;

import com.pinapp.market.marketservice.controller.request.DetailRequest;
import com.pinapp.market.marketservice.domain.mapper.DetailMapper;
import com.pinapp.market.marketservice.domain.model.Detail;
import com.pinapp.market.marketservice.domain.model.SaleNote;
import com.pinapp.market.marketservice.repository.DetailRepository;
import com.pinapp.market.marketservice.repository.SaleNoteRepository;
import com.pinapp.market.marketservice.service.IDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
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

        return null;
    }

    public Detail createDetail(DetailRequest detailRequest) {

        Detail detailNew;
        Detail detail = detailMapper.apply(detailRequest);
        detailNew = detail;
        detailNew.setId(null);
        if(detailRequest.getSaleNote() != null){
            Optional<SaleNote> sale = saleNoteRepository.findById(detailRequest.getSaleNote().getId());
            detailNew.setSaleNote(sale.get());
        }
        detailRepository.save(detailNew);
        log.info("Se cargo el DETALLE  con éxito");

        return detailNew;
    }

    public String editDetail(Long id, DetailRequest detailRequest) {
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
            if (detailActu.getSaleNote() != null) detailActu.setSaleNote(detailActu.getSaleNote());
        }
        if (detailActu != null) {
            detailRepository.save(detailActu);
            log.info("Se actualizo el DETALLE con éxito");
            return "Se actualizo el DETALLE con éxito";
        }

        log.info("El DETALLE no se actualizo correctamente (NULL)");
        return "El DETALLE no se actualizo correctamente (NULL)";
    }

    @Transactional
    @Modifying
    public String deleteDetail(Long idSaleNote, Long idDetail)
    {
        Optional<SaleNote> saleNoteOP = saleNoteRepository.findById(idSaleNote);
        if (saleNoteOP.isPresent()) {
            SaleNote sn = saleNoteOP.get();
            Optional<Detail>  d = sn.getDetails().stream().filter( e -> e.getId().equals(idDetail)).findFirst() ;

            if( d.isPresent())
            {
               // List<Detail> dl = sn.getDetails();
               // dl.remove()
                Detail dd= d.get();
                detailRepository.delete(dd);

                log.info("Se elimino el detalle con exito");
                return null;
            }else
            {
                log.error("no se encontro el detalle");
                // TODO: lanzar una excepcion
                return null;
            }

        } else {
            log.error("no se encontro el pedido");
            // TODO: lanzar una excepcion
            return null;
        }
    }


}
