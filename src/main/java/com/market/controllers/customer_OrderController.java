package com.market.controllers;

import com.market.models.Order;
import com.market.services.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class customer_OrderController {
    @Autowired
    OrderServiceImp orderServiceImp;
    @GetMapping("/history/{id}")
    public ResponseEntity<?> OrderHistory(@PathVariable("id") String id){
        try{
            List<Order> lo = orderServiceImp.getAllOrder(id);
            if (lo.isEmpty()){
                return new ResponseEntity<>("No order found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(lo,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteOrder(@PathVariable("id") String id){
        try{
            if(orderServiceImp.deleteById(id)){
                return new ResponseEntity<>("Delete success",HttpStatus.OK);
            }
            return new ResponseEntity<>("Delete fail",HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
