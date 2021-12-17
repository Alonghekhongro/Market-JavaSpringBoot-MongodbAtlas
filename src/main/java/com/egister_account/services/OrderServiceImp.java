package com.egister_account.services;

import com.egister_account.models.Order;
import com.egister_account.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService{
    @Autowired
    OrderRepository orderRepository;
    @Override
    public List<Order> getAllOrder(){
        return orderRepository.getAllOrder();
    }
}
