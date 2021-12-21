package com.market.services;

import com.market.models.Store;

import java.util.List;

public interface StoreService {
    public Store reviewStore (Store storee);
    public List<Store> getAllStore();
};
