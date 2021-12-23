package com.market.services;

import com.market.models.Store;

import java.util.List;

public interface StoreService {
    public Store reviewStore (Store storee);
    public Store getFullUser(String username);
    public Store loadUser(Store store);
    public List<Store> getAllStore();
};
