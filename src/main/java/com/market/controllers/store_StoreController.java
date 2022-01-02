package com.market.controllers;

import com.market.models.Product;
import com.market.models.Register;
import com.market.models.Store;
import com.market.services.ProductServiceImp;
import com.market.services.RegisterServiceImp;
import com.market.services.StoreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/store")
public class store_StoreController {
    @Autowired
    RegisterServiceImp registerServiceImp;
    @Autowired
    StoreServiceImp storeServiceImp;
    @Autowired
    ProductServiceImp productServiceImp;
    @PostMapping("/register")
    public ResponseEntity<?> RegisterSale(@RequestBody Register register){
        try{
            Register re = registerServiceImp.saveStoreRegister(register);
            if (re == null){
                return new ResponseEntity<>("Registration form sent", HttpStatus.NOT_ACCEPTABLE);
            }
            return new ResponseEntity<>(re,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody Store store){
        try {
            Store st = storeServiceImp.loadUser(store);
            if (st == null) {
                return new ResponseEntity<>("User not found", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
            }
            st = storeServiceImp.getFullUser(store.getUsername());
            return new ResponseEntity<>(st, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("User not found", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
    }
    @GetMapping("/storedetail/{id}")
    public ResponseEntity<?> StoreDetail(@PathVariable("id") String id){
        try {
            Optional<Store> store = storeServiceImp.getStore(id);
            if(store.isPresent()){
                Store st = store.get();
                return new ResponseEntity<>(st,HttpStatus.OK);
            }
            return new ResponseEntity<>("Not found",HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Not found",HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/product")
    public ResponseEntity<?> AddProduct(@RequestBody Product product){
        try{
            Product pr = productServiceImp.saveProduct(product);
            return new ResponseEntity<>(pr,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
