package com.pinapp.market.marketservice.repository;

import com.pinapp.market.marketservice.domain.model.SaleNote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;
import java.util.Optional;


@Repository
public interface SaleNoteRepository extends CrudRepository<SaleNote, Long>{

    @Query(value = "SELECT * FROM sale_note WHERE state = 'INPROCESS' OR state = 'ISSUED'", nativeQuery = true)
    List<SaleNote> getState();

    @Query(value = "SELECT * FROM sale_note WHERE state = 'CANCELLED'", nativeQuery = true)
    List<SaleNote> getStateCanceled();

}
