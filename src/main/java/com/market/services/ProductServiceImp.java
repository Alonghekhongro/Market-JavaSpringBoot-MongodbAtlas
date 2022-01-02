package com.market.services;

import com.market.models.Product;
import com.market.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public boolean deleteById(String id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            Product pro = product.get();
            pro.setActivity(false);
            productRepository.save(pro);
            return true;
        }
        return false;
    }
    @Override
    public Product saveProduct(Product product){
        product.setCreate_date(new Date(System.currentTimeMillis()));
        product.setUpdate_date(new Date(System.currentTimeMillis()));
        product.setActivity(true);
        return productRepository.save(product);
    }
    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }
}