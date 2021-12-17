package com.egister_account.repositories;

import com.egister_account.models.Customer;
import com.egister_account.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    @Query("{customer_id:'?0', activity: true}")
    List<Order> getAllOrder(String id);

}
