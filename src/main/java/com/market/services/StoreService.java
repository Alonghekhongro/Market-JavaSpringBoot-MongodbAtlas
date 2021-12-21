package com.market.services;

import com.market.models.Store;

import java.util.List;

public interface StoreService {
    public Store saveStore(Store store);
    public Store reviewStore (Store store);
    public List<Store> getAllStore();
};
