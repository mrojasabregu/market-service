package main.java.com.pinapp.market.marketservice.repository;

import com.pinapp.market.marketservice.domain.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{
    
    
}
