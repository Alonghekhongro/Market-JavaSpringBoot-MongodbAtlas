package com.egister_account.controllers;

import com.egister_account.models.Store;
import com.egister_account.services.StoreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/store")
public class store_StoreController {
    @Autowired
    StoreServiceImp storeServiceImp;
    @PostMapping("/register")
    public ResponseEntity<?> RegisterSale(@RequestBody Store store){
        try{
            Store st = storeServiceImp.saveStore(store);
            if (st == null){
                return new ResponseEntity<>("Store existed", HttpStatus.NOT_ACCEPTABLE);
            }
            return new ResponseEntity<>(st,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
