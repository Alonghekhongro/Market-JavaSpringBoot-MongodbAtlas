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
    public List<Order> getAllOrder(String id){
        System.out.println(id);
        for (Order order : orderRepository.getAllOrder(id))
        {
            System.out.println(order.getId());
        }
        return orderRepository.getAllOrder(id);
    }
}
