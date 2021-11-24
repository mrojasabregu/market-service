package com.pinapp.market.marketservice.repository;

import com.pinapp.market.marketservice.domain.entity.Detail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends CrudRepository<Detail, Long> {

}
