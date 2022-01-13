package com.market.controllers;

import com.market.models.Register;
import com.market.models.Store;
import com.market.services.RegisterServiceImp;
import com.market.services.StoreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class admin_StoreController {
    @Autowired
    StoreServiceImp storeServiceImp;
    @Autowired
    RegisterServiceImp registerServiceImp;
    @PostMapping("/reviewstore")
    public ResponseEntity<?> ReviewRegisterSale(@RequestBody Store store){
        try{
            Store st = storeServiceImp.reviewStore(store);
            if (st == null){
                return new ResponseEntity<>("Registration form not found or " +
                        "have been insert" , HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(st,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/storeregister")
    public ResponseEntity<?> GetAllStoreRegister(){
        try{
            List<Register> re = registerServiceImp.getAllRegister();
            if (re.isEmpty()){
                return new ResponseEntity<>("No store register found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(re,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/find/register/{id}")
    public ResponseEntity<?> FindRegister(@PathVariable("id") String id){
        try {
            Optional<Register> register = registerServiceImp.findbyID(id);
            if( register.isPresent()){
                Register reg = register.get();
                return new ResponseEntity<>(reg,HttpStatus.OK);
            }
            return new ResponseEntity<>("Not found",HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Not found",HttpStatus.NOT_FOUND);
        }
    }
}
