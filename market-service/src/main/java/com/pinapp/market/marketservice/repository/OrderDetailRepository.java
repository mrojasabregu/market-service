package com.pinapp.market.marketservice.repository;

import com.pinapp.market.marketservice.domain.model.SaleNoteDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends CrudRepository<SaleNoteDetail, Long> {
}
