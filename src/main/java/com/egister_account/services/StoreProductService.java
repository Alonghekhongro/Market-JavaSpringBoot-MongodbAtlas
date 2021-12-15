package com.egister_account.services;

import com.egister_account.models.StoreProduct;

import java.util.List;

public interface StoreProductService {
    public List<StoreProduct> getStoreProduct(String product_name);
}
