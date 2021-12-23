package com.market.controllers;

import com.market.models.Admin;
import com.market.services.AdminServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class admin_AdminController {
    @Autowired
    AdminServiceImp adminServiceImp;
    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody Admin admin){
        try{
            Admin ad = adminServiceImp.saveUser(admin);
            if (ad == null){
                return new ResponseEntity<>("Username existed",HttpStatus.NOT_ACCEPTABLE);
            }
            return new ResponseEntity<>(ad,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody Admin admin){
        try {
            Admin ad = adminServiceImp.loadUser(admin);
            if (ad == null) {
                return new ResponseEntity<>("User not found", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
            }
            ad = adminServiceImp.getFullUser(admin.getUsername());
            return new ResponseEntity<>(ad, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("User not found", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
    }
}
