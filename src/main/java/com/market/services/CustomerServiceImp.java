package com.market.services;

import com.market.models.Customer;
import com.market.models.Customer_sta;
import com.market.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    CustomerRepository customer_repo;
    @Override
    public Optional<Customer> findbyID(String id){
        if(customer_repo.existsById(id)){
            return customer_repo.findById(id);
        }
        return null;
    }
    @Override
    public Customer getFullUser(String username){
        return customer_repo.findByUserName(username);
    }
    @Override
    public Customer saveUser(Customer user){
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

    @Override
    public List<Customer_sta> getAllCustomerByRegion(){
        List<Customer_sta> list_cus_sta = new ArrayList<Customer_sta>();
        List<String> regions = new ArrayList<String>();
        regions.add("Vùng đỏ");
        regions.add("Vùng xanh");
        regions.add("Vùng cam");
        regions.add("Vùng vàng");
        for (String region : regions){
            Integer count =  customer_repo.getAllByRegion(region).size();
            Customer_sta cus_sta = new Customer_sta(count, region);
            list_cus_sta.add(cus_sta);
        }
        return list_cus_sta;
    }
}