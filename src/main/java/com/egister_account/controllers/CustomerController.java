package com.egister_account.controllers;

import com.egister_account.models.Customer;
import com.egister_account.repositories.CustomerRepository;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.util.Date;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerRepository customer_repo;
    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody Customer customer){
        try{
            String password = customer.getPassword();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            String HashPW = DatatypeConverter.printHexBinary(digest).toUpperCase();
            customer.setCreate_date(new Date(System.currentTimeMillis()));
            customer.setUpdate_date(new Date(System.currentTimeMillis()));
            customer.setPassword(HashPW);
            customer_repo.save(customer);
            return new ResponseEntity<>(customer,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
