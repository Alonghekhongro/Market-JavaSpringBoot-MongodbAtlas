package com.egister_account.repositories;

import com.egister_account.models.Customer;
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
    @Query("{activity: true}")
    List<Customer> getAllCustomer();
}
