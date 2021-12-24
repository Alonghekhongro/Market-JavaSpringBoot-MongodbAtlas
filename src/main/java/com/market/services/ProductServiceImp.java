package com.market.services;

import com.market.models.Product;
import com.market.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}