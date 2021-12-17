package com.egister_account.controllers;

import com.egister_account.models.Customer;
import com.egister_account.models.Order;
import com.egister_account.services.CustomerServiceImp;
import com.egister_account.services.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderServiceImp orderServiceImp;
    @GetMapping("/history")
    public ResponseEntity<?> OrderHistory(){
        try{
            List<Order> lo = orderServiceImp.getAllOrder();
            if (lo.isEmpty()){
                return new ResponseEntity<>("No order found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(lo,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
