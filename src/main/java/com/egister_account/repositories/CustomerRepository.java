package com.egister_account.repositories;

import com.egister_account.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    @Query("{username:'?0'}")
    Customer findByUsername(String username);
    @Query("{password:'?0'}")
    Customer findByPassword(String pw);
    @Query("{activity: true}")
    List<Customer> getAllCustomer();
}
