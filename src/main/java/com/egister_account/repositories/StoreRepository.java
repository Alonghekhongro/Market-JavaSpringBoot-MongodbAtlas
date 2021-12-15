package com.egister_account.repositories;

import com.egister_account.models.Store;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StoreRepository extends MongoRepository<Store, String> {

}
