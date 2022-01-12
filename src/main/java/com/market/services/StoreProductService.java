package com.market.services;

import com.market.models.OneStoreProduct;
import com.market.models.StoreProduct;

import java.util.List;

public interface StoreProductService {
    public List<StoreProduct> getStoreProduct(String product_name);
    public List<StoreProduct> getOneStoreProduct(OneStoreProduct oneStoreProduct);
}
