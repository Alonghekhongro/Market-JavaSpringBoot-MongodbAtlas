package com.market.services;

import com.market.models.Product;

import java.util.List;

public interface ProductService {
    public boolean deleteById(String id);
    public Product saveProduct(Product product);
    public List<Product> getAllProduct();
}
