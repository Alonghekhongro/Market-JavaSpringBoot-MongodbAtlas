package com.market.services;

import com.market.models.Order;
import com.market.models.Order_Item;
import com.market.repositories.OrderRepository;
import com.market.repositories.Order_ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService{
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderItemServiceImp orderItemServiceImp;
    @Autowired
    Order_ItemRepository order_itemRepository;
    @Override
    public List<Order> getAllOrder(String cus_id){
        List<Order> list_order = new ArrayList<Order>();
        if(orderRepository.getAllOrder().isEmpty()){
            return list_order;
        }
        for (Order order : orderRepository.getAllOrder()){
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
            if(orderItemServiceImp.getAllOrderItem(id).isEmpty()){
                return false;//Chi tiet don dat hang null trong khi co don dat hang
            }
            for (Order_Item order_item : orderItemServiceImp.getAllOrderItem(id)){
                order_itemRepository.deleteById(order_item.getId());
            }
            return true;
        }
        return false;
    }

}
