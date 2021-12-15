package com.egister_account.controllers;

import com.egister_account.models.Customer;
import com.egister_account.models.Product;
import com.egister_account.services.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerServiceImp customer_imp;
    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody Customer customer){
        try{
            Customer c = customer_imp.saveUser(customer);
            if (c == null){
                return new ResponseEntity<>("Username existed",HttpStatus.NOT_ACCEPTABLE);
            }
            return new ResponseEntity<>(c,HttpStatus.OK);
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
    @GetMapping("/find/{id}")
    public ResponseEntity<?> FindCustomer(@PathVariable("id") String id){
        try {
            Optional<Customer> customer_date = customer_imp.findbyID(id);
            Customer cus = customer_date.get();
            cus.setPassword(null);
            return new ResponseEntity<>(cus,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
}
