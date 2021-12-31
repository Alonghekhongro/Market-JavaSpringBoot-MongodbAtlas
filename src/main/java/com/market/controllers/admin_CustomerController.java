package com.market.controllers;

import com.market.models.Customer;
import com.market.services.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class admin_CustomerController {
    @Autowired
    CustomerServiceImp customerServiceImp;
    @GetMapping("/list_customer")
    public ResponseEntity<?> GetAllCustomer(){
        try{
            List<Customer> cu = customerServiceImp.getAllCustomer();
            if (cu.isEmpty()){
                return new ResponseEntity<>("No customer found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(cu,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
