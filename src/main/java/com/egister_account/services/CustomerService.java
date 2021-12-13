package com.egister_account.services;

import com.egister_account.models.Customer;


import java.util.List;

public interface CustomerService {
    public Boolean getUser(String username, String password);
    public Customer getFullUser(String username);
    public Customer saveUser(Customer user);
    public Customer loadUser(Customer user);
    public List<Customer> getAllCustomer();
}
