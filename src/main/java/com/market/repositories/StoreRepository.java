package com.market.repositories;

import com.market.models.Store;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface StoreRepository extends MongoRepository<Store, String> {
    @Query("{username:'?0', password:'?1'}")
    Store findByUser(String username, String password);
    @Query("{username:'?0'}")
    Store findByUserName(String username);
    @Query("{region:'?0'}")
    List<Store> getAllByRegion(String region);
    @Query("{activity: true}")
    List<Store> getAllStore();
}
