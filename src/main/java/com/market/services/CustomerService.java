package com.market.services;

import com.market.models.Customer;
import com.market.models.Customer_sta;


import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public Customer getFullUser(String username);
    public Customer saveUser(Customer user);
    public Customer loadUser(Customer user);
    public Optional<Customer> findbyID(String id);
    public List<Customer> getAllCustomer();
    public List<Customer_sta> getAllCustomerByRegion();
}
