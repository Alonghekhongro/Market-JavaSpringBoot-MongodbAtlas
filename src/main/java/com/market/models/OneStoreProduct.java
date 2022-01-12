package com.market.models;


public class OneStoreProduct {
    private String store_id;
    private String product_name;

    public OneStoreProduct() {
        super();
    }

    public OneStoreProduct(String store_id, String product_name) {
        super();
        this.store_id = store_id;
        this.product_name = product_name;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
}
