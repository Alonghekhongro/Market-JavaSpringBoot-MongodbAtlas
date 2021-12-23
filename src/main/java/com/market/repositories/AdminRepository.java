package com.market.repositories;

import com.market.models.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AdminRepository extends MongoRepository<Admin, String> {
    @Query("{username:'?0', password:'?1'}")
    Admin findByUser(String username, String password);
    @Query("{username:'?0'}")
    Admin findByUserName(String username);
    @Query("{activity: true}")
    List<Admin> getAllAdmin();
}
