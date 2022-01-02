package com.market.controllers;

import com.market.models.Customer_sta;
import com.market.models.Store_sta;
import com.market.services.CustomerServiceImp;
import com.market.services.StoreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class admin_StatisticController {
    @Autowired
    CustomerServiceImp customerServiceImp;
    @Autowired
    StoreServiceImp storeServiceImp;
    @GetMapping("/customer_region")
    public ResponseEntity<?> GetAllCustomerByRegion(){
        try{
            List<Customer_sta> cu_sta = customerServiceImp.getAllCustomerByRegion();
            if (cu_sta.isEmpty()){
                return new ResponseEntity<>("No customer found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(cu_sta,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/store_region")
    public ResponseEntity<?> GetAllStoreByRegion(){
        try{
            List<Store_sta> sto_sta = storeServiceImp.getAllStoreByRegion();
            if (sto_sta.isEmpty()){
                return new ResponseEntity<>("No store found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(sto_sta,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
