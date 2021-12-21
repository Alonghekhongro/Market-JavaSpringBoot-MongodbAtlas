package com.market.repositories;

import com.market.models.Register;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RegisterRepository extends MongoRepository<Register, String> {
    @Query("{activity: true}")
    List<Register> getAllRegister();
}
