package com.market.controllers;

import com.market.models.Store;
import com.market.services.StoreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class admin_StoreController {
    @Autowired
    StoreServiceImp storeServiceImp;
    @PostMapping("/reviewstore")
    public ResponseEntity<?> ReviewRegisterSale(@RequestBody Store store){
        try{
            Store st = storeServiceImp.reviewStore(store);
            if (st == null){
                return new ResponseEntity<>("Store not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(st,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
