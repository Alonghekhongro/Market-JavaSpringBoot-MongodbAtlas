package com.market.controllers;

import com.market.models.Register;
import com.market.models.Store;
import com.market.services.RegisterServiceImp;
import com.market.services.StoreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/store")
public class store_StoreController {
    @Autowired
    RegisterServiceImp registerServiceImp;
    @Autowired
    StoreServiceImp storeServiceImp;
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
}
