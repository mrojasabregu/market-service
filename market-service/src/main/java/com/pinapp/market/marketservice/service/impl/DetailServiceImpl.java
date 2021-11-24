package com.pinapp.market.marketservice.service.impl;

import com.pinapp.market.marketservice.config.exception.BadRequestException;
import com.pinapp.market.marketservice.config.exception.NotFoundException;
import com.pinapp.market.marketservice.controller.request.DetailRequest;
import com.pinapp.market.marketservice.controller.response.DetailResponse;
import com.pinapp.market.marketservice.controller.response.SaleNoteResponse;
import com.pinapp.market.marketservice.domain.mapper.DetailRequestMapper;
import com.pinapp.market.marketservice.domain.mapper.DetailResponseMapper;
import com.pinapp.market.marketservice.domain.mapper.SaleNoteResponseMapper;
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
import java.util.stream.Collectors;

@Slf4j
@Service
public class DetailServiceImpl implements IDetailService {


    @Autowired
    private DetailRequestMapper detailMapper;

    @Autowired
    private DetailResponseMapper detailResponseMapper;

    @Autowired
    private SaleNoteResponseMapper saleNoteResponseMapper;

    @Autowired
    private DetailRepository detailRepository;

    @Autowired
    private SaleNoteRepository saleNoteRepository;


    public DetailResponse getDetail(Long id) {
        Optional<Detail> detail = detailRepository.findById(id);
        if (detail.isPresent()) {
            log.info("Se mostro con éxito el DETALLE");
            DetailResponse detailR = detailResponseMapper.apply(detail.get());
            return detailR;
        }
        log.error("NO se pudo mostrar el DETALLE");
        throw new NotFoundException("Detail does not exist");
    }

    @Transactional
    public SaleNoteResponse createDetail(DetailRequest detailRequest, Long saleNoteId) {
        Detail detailNew;
        Detail detail = detailMapper.apply(detailRequest);
        detailNew = detail;
        detailNew.setId(null);
        Optional<SaleNote> sale = saleNoteRepository.findById(saleNoteId);
        if (sale.isPresent()) {
            SaleNote s = sale.get();
            s.getDetails().add(detailNew);
            s = saleNoteRepository.save(s);
            log.info("Se cargo el DETALLE  con éxito");
            SaleNoteResponse saleNoteResponse = saleNoteResponseMapper.apply(s);
            saleNoteResponse.getDetails().stream().forEach(d -> d.setSubtotal(d.getPrice().multiply(d.getAmount())));
            return saleNoteResponse;
        } else {
            log.error("NO se pudo mostrar el DETALLE");
            throw new BadRequestException("Invalid Sale Note");
        }
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

        }
        if (detailActu != null) {
            detailRepository.save(detailActu);
            log.info("Se actualizo el DETALLE con éxito");
            return true;
        }
        //TODO excepcion
        log.error("El DETALLE no se actualizo correctamente (NULL)");
        return false;
    }

    @Transactional
    @Modifying
    public String deleteDetail(Long idSaleNote, Long idDetail) {
        Optional<Detail> d = detailRepository.findById(idDetail);
        if (d.isPresent()) {
            Detail dd = d.get();
            Optional<SaleNote> sale = saleNoteRepository.findById(idSaleNote);
            if (sale.isPresent()) {
                sale.get().getDetails().remove(dd);
            } else {
                //TODO lanzar excepcion avisando que no existe el pedido
                log.error("El PEDIDO no existe");
            }
            detailRepository.delete(dd);
            log.info("Se elimino el detalle con exito");
        } else {
            log.error("no se encontro el detalle para ser eliminado");
            // TODO: lanzar una excepcion
        }
        return null;
    }


}
