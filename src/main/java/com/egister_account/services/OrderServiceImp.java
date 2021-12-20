package com.egister_account.services;

import com.egister_account.models.Order;
import com.egister_account.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService{
    @Autowired
    OrderRepository orderRepository;
    @Override
    public List<Order> getAllOrder(String cus_id){
        List<Order> list_order = new ArrayList<Order>();
        if(orderRepository.getAllOrder(cus_id).isEmpty()){
            return list_order;
        }
        for (Order order : orderRepository.getAllOrder(cus_id)){
            if (order.getCustomer_id().equals(cus_id)){
                list_order.add(order);
            }
        }
        return list_order;
    }
    @Override
    public boolean deleteById(String id){
        if(orderRepository.existsById(id)){
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
