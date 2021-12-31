package com.market.services;

import com.market.models.Order_Item;
import com.market.repositories.Order_ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemServiceImp implements OrderItemService{
    @Autowired
    Order_ItemRepository order_itemRepository;
    @Override
    public List<Order_Item> getAllOrderItem(String id){
        List<Order_Item> list_order_item = new ArrayList<Order_Item>();
        if(order_itemRepository.getAllOrderItem().isEmpty()){
            return list_order_item;
        }
        for (Order_Item order_item : order_itemRepository.getAllOrderItem()){
            if (order_item.getOrder_id().equals(id)){
                list_order_item.add(order_item);
            }
        }
        return list_order_item;
    }
}
