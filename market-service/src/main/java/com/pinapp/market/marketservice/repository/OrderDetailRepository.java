package com.pinapp.market.marketservice.repository;

import com.pinapp.market.marketservice.domain.model.OrderDetail;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailRepository  extends CrudRepository<OrderDetail, Long> {


}
