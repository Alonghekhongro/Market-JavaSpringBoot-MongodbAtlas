package com.market.services;

import com.market.models.StoreProduct;

import java.util.List;

public interface StoreProductService {
    public List<StoreProduct> getStoreProduct(String product_name);
}
