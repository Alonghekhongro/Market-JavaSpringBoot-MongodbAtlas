package com.market.services;

import com.market.models.Register;

import java.util.List;

public interface RegisterService {
    public Register saveStoreRegister(Register register);
    public List<Register> getAllRegister();
}
