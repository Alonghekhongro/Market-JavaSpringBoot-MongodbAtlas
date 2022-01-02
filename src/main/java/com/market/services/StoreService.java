package com.market.services;

import com.market.models.Store;
import com.market.models.Store_sta;

import java.util.List;
import java.util.Optional;

public interface StoreService {
    public Store reviewStore (Store storee);
    public Store getFullUser(String username);
    public Store loadUser(Store store);
    public List<Store> getAllStore();
    public Optional<Store> getStore(String id);
    public List<Store_sta> getAllStoreByRegion();
};
