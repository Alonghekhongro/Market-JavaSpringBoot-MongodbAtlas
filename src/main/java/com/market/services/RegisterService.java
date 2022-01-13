package com.market.services;

import com.market.models.Register;

import java.util.List;
import java.util.Optional;

public interface RegisterService {
    public Register saveStoreRegister(Register register);
    public List<Register> getAllRegister();
    public Optional<Register> findbyID(String id);
}
