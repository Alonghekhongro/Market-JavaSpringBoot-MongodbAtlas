package com.market.models;

import java.util.List;

public class StoreProduct {
    String store_name;
    String store_address;
    List<Product> product;

    public StoreProduct(){super();}
    public StoreProduct(String store_name, String store_address, List<Product> product) {
        super();
        this.store_name = store_name;
        this.store_address = store_address;
        this.product = product;
    }

    public String getStore_name() {
        return store_name;
    }
    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }
    public String getStore_address() {
        return store_address;
    }
    public void setStore_address(String store_address) {
        this.store_address = store_address;
    }
    public List<Product> getProduct() {
        return product;
    }
    public void setProduct(List<Product> product) {
        this.product = product;
    }
}