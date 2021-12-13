package com.egister_account.controllers;

import com.egister_account.models.Customer;
import com.egister_account.services.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerServiceImp customer_imp;
    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody Customer customer){
        try{
            customer_imp.saveUser(customer);
            return new ResponseEntity<>(customer_imp.saveUser(customer),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody Customer customer){
        try {
            Customer c = customer_imp.loadUser(customer);
            if (c == null) {
                return new ResponseEntity<>("User not found", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
            }
            c = customer_imp.getFullUser(customer.getUsername());
            return new ResponseEntity<>(c, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("User not found", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
    }
}
