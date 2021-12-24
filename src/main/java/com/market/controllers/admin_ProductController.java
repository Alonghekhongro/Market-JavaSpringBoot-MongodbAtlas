package com.market.controllers;

import com.market.services.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class admin_ProductController {
    @Autowired
    ProductServiceImp productServiceImp;
    @PutMapping("/delete_product/{id}")
    public ResponseEntity<?> DeleteProduct(@PathVariable("id") String id){
        try{
            if(productServiceImp.deleteById(id)){
                return new ResponseEntity<>("Delete success", HttpStatus.OK);
            }
            return new ResponseEntity<>("Delete fail",HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
