package com.market.controllers;

import com.market.models.Register;
import com.market.services.RegisterServiceImp;
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
}
