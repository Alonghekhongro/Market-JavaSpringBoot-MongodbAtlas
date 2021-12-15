package com.egister_account.services;

import com.egister_account.models.Customer;
import com.egister_account.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    CustomerRepository customer_repo;
    @Override
    public Optional<Customer> findbyID(String id){
        return customer_repo.findById(id);
    }
    @Override
    public Customer getFullUser(String username){
        return customer_repo.findByUserName(username);
    }
    @Override
    public Customer saveUser(Customer user){
        if (user != null) {
            for (Customer customer : getAllCustomer()){
                if (customer.getUsername().equals(user.getUsername())){
                    return null;
                }
            }
            user.setCreate_date(new Date(System.currentTimeMillis()));
            user.setUpdate_date(new Date(System.currentTimeMillis()));
            user.setActivity(true);
            return customer_repo.save(user);
        }
        return null;
    }
    @Override
    public Customer loadUser(Customer user) {
        Customer customer = customer_repo.findByUser(user.getUsername(), user.getPassword());
        if(customer != null)
            return user;
        return null;
    }
    @Override
    public List<Customer> getAllCustomer() {
        return customer_repo.getAllCustomer();
    }
}