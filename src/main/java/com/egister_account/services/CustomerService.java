package com.egister_account.services;

import com.egister_account.models.Customer;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public Customer findByUsername(String username);
    public Customer saveUser(Customer user) throws NoSuchAlgorithmException;
    public List<Customer> getAllCustomer();
}
