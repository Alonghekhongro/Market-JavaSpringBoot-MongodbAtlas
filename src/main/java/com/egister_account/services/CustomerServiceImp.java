package com.egister_account.services;

import com.egister_account.models.Customer;
import com.egister_account.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    CustomerRepository customer_repo;

    @Override
    public Boolean getUser(String username, String password) {
        String pw = customer_repo.findByUsername(username).getPassword();
        String pw1 = customer_repo.findByPassword(password).getPassword();
        String us = customer_repo.findByUsername(username).getUsername();
        String us1 = customer_repo.findByPassword(password).getUsername();
        if (us.equals(us1)){
            if(pw.equals(pw1)){
                return true;
            }
            return false;
        }
        return false;
    }
    @Override
    public Customer getFullUser(String username){
        return customer_repo.findByUsername(username);
    }
    @Override
    public Customer saveUser(Customer user){
        if (user != null) {
            user.setCreate_date(new Date(System.currentTimeMillis()));
            user.setUpdate_date(new Date(System.currentTimeMillis()));
            user.setActivity(true);
            return customer_repo.save(user);
        }
        return null;
    }
    @Override
    public Customer loadUser(Customer user) {
        if(getUser(user.getUsername(), user.getPassword()))
            return user;
        return null;
    }
    @Override
    public List<Customer> getAllCustomer() {
        return customer_repo.getAllCustomer();
    }
}