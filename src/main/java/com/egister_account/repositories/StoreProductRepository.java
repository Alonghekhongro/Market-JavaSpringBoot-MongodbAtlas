package com.egister_account.repositories;

import com.egister_account.models.StoreProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoreProductRepository extends MongoRepository<StoreProduct, String> {
}
