package com.pinapp.market.marketservice.service.impl;

import com.pinapp.market.marketservice.client.ProductClient;
import com.pinapp.market.marketservice.config.exception.BadRequestException;
import com.pinapp.market.marketservice.config.exception.CustomException;
import com.pinapp.market.marketservice.config.exception.NotFoundException;
import com.pinapp.market.marketservice.controller.request.DetailRequest;
import com.pinapp.market.marketservice.domain.mapper.DetailRequestMapper;
import com.pinapp.market.marketservice.domain.entity.Detail;
import com.pinapp.market.marketservice.domain.entity.SaleNote;
import com.pinapp.market.marketservice.domain.model.Product;
import com.pinapp.market.marketservice.repository.DetailRepository;
import com.pinapp.market.marketservice.repository.SaleNoteRepository;
import com.pinapp.market.marketservice.service.IDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class DetailServiceImpl implements IDetailService {


    @Autowired
    private DetailRequestMapper detailMapper;

    @Autowired
    private DetailRepository detailRepository;

    @Autowired
    private SaleNoteRepository saleNoteRepository;

    @Autowired
    private ProductClient productClient;


    public Detail getDetail(Long id) {
        if(id.getClass() != Long.class){
            throw new NumberFormatException("Invalid ID");
        }
        Optional<Detail> detail = detailRepository.findById(id);
        if (detail.isPresent()) {
            log.info("Se mostro con éxito el DETALLE");
            return detail.get();
        }
        log.error("NO se pudo mostrar el DETALLE");
        throw new NotFoundException("Detail does not exist");
    }

    @Transactional
    public void createDetail(DetailRequest detailRequest, Long saleNoteId) {
        Detail detailNew;
        Detail detail = detailMapper.apply(detailRequest);
        detailNew = detail;
        detailNew.setId(null);
        Optional<SaleNote> sale = saleNoteRepository.findById(saleNoteId);
        if (sale.isPresent()) {
            SaleNote s = sale.get();
            ResponseEntity<Product> product = productClient.retriveProduct(detail.getSku());

            detail.setPrice(BigDecimal.valueOf(product.getBody().getPrice()));

            if(product.getBody().getUnitAvailable() - detail.getAmount().intValue() < 0){
                throw new CustomException("Stock no disponible para Sku: " + detail.getSku() + ". La cantidad disponible es " +
                        " de: " + product.getBody().getUnitAvailable());
            }

            


            s.getDetails().add(detailNew);
            saleNoteRepository.save(s);
            log.info("Se cargo el DETALLE  con éxito");
        } else {
            log.error("NO se pudo mostrar el DETALLE");
            throw new BadRequestException("Invalid Sale Note");
        }
    }

    public Boolean editDetail(Long id, DetailRequest detailRequest) {
        if(id.getClass() != Long.class){
            throw new NumberFormatException("Invalid ID");
        }
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
