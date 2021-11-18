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

    @Query(value = "SELECT * FROM SALE_NOTE WHERE state = 'En proceso'", nativeQuery = true)
    List<SaleNote> getState();

}
