package com.egister_account.repositories;

import com.egister_account.models.Store;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface StoreRepository extends MongoRepository<Store, String> {
    @Query("{activity: true}")
    List<Store> getAllStore();
}
