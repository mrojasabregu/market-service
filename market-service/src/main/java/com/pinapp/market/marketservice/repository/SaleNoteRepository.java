package com.pinapp.market.marketservice.repository;

import com.pinapp.market.marketservice.domain.model.SaleNote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SaleNoteRepository extends CrudRepository<SaleNote, Long>{

    List<SaleNote> findByIdSaleNote(Long id);
}
