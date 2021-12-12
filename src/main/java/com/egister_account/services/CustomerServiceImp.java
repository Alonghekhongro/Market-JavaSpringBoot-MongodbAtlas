package com.egister_account.services;

import com.egister_account.models.Customer;
import com.egister_account.repositories.CustomerRepository;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService{
    @Autowired
    CustomerRepository customer_repo;
    @Override
    public Customer findByUsername(String username){
        return customer_repo.findByUsername(username);
    }
    @Override
    public Customer saveUser(Customer user) throws NoSuchAlgorithmException {
        if (user != null){
            String password = user.getPassword();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            String HashPW = DatatypeConverter.printHexBinary(digest).toUpperCase();
            user.setCreate_date(new Date(System.currentTimeMillis()));
            user.setUpdate_date(new Date(System.currentTimeMillis()));
            user.setPassword(HashPW);
            user.setActivity(true);
            return customer_repo.save(user);
        }
        return null;
    }
    @Override
    public List<Customer> getAllCustomer(){
        return customer_repo.getAllCustomer();
    }
}
