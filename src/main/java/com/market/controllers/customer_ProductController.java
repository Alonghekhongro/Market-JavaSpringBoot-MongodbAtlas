package com.market.controllers;

import com.market.models.StoreProduct;
import com.market.services.StoreProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class customer_ProductController {
    //@Autowired
    //ProductServiceImp productServiceImp;
    @Autowired
    StoreProductServiceImp storeProductServiceImp;
    @GetMapping("/find")
    public ResponseEntity<?> FindProduct(@RequestParam(value = "name", defaultValue = "")
                                                     String name) {
        try {
            List<StoreProduct> storeProduct = storeProductServiceImp.getStoreProduct(name);
            if(storeProduct.isEmpty()){
                return new ResponseEntity<>("Not found",HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(storeProduct,
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
}
