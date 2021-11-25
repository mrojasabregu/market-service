package com.pinapp.market.marketservice.repository;

import com.pinapp.market.marketservice.domain.entity.SaleNote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SaleNoteRepository extends CrudRepository<SaleNote, Long>{

    @Query(value = "SELECT * FROM sale_note WHERE state = 'INPROCESS' OR state = 'ISSUED'", nativeQuery = true)
    List<SaleNote> getState();

    @Query(value = "SELECT * FROM sale_note WHERE state = 'CANCELLED'", nativeQuery = true)
    List<SaleNote> getStateCanceled();

}
