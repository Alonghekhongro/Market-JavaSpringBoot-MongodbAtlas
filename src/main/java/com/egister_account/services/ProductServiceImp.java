package com.egister_account.services;

import com.egister_account.models.Product;
import com.egister_account.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductRepository productRepository;
}