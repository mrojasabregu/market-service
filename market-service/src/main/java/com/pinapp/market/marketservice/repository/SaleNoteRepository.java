package com.pinapp.market.marketservice.repository;

import com.pinapp.market.marketservice.domain.model.SaleNote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface SaleNoteRepository extends CrudRepository<SaleNote, Long>{

    Optional<SaleNote> findById(Long id);

    List<SaleNote> findAll();

}
