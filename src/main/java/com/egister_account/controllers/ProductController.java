package com.egister_account.controllers;

import com.egister_account.models.Product;
import com.egister_account.repositories.ProductRepository;
import com.egister_account.services.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
    //@Autowired
    //ProductServiceImp productServiceImp;
    @Autowired
    ProductRepository productRepository;
    @GetMapping("/find")
    public ResponseEntity<List<Product>> FindProduct(@RequestParam(value = "name", defaultValue = "")
                                                     String name) {
        try {
            return new ResponseEntity<>(productRepository.search(name),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
}
