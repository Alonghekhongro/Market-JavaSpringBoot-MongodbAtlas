package com.egister_account.repositories;

import com.egister_account.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    //{name: {$regex: /Giá/, $options: 'i'}}
    @Query("{name: {$regex: /?0/, $options: 'i'}}")
    List<Product> search(String name);
}