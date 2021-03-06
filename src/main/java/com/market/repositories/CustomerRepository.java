package com.market.repositories;

import com.market.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    @Query("{username:'?0', password:'?1'}")
    Customer findByUser(String username, String password);
    @Query("{username:'?0'}")
    Customer findByUserName(String username);
    //{name: {$regex: /Giá/, $options: 'i'}}
    @Query("{region:'?0'}")
    List<Customer> getAllByRegion(String region);
    @Query("{activity: true}")
    List<Customer> getAllCustomer();
}
