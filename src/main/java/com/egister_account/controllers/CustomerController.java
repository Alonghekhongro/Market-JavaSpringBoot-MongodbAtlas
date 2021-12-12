package com.egister_account.controllers;

import com.egister_account.models.Customer;
import com.egister_account.repositories.CustomerRepository;
import com.egister_account.services.CustomerServiceImp;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerServiceImp customer_imp;
    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody Customer customer){
        try{
            //Customer c = customer_imp.findByUsername("ABC");
            //for (Customer c : customer_imp.getAllCustomer())
            //{
            //    System.out.println(c.getId());
            //}
            customer_imp.saveUser(customer);
            return new ResponseEntity<>(customer_imp.saveUser(customer),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
