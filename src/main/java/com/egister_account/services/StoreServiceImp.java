package com.egister_account.services;

import com.egister_account.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImp implements StoreService {
    @Autowired
    StoreRepository storeRepository;
}
