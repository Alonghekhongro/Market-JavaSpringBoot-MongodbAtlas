package com.egister_account.services;

import com.egister_account.models.Customer;


import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public Customer getFullUser(String username);
    public Customer saveUser(Customer user);
    public Customer loadUser(Customer user);
    public Optional<Customer> findbyID(String id);
    public List<Customer> getAllCustomer();
}
