package com.market.services;

import com.market.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductRepository productRepository;
}