package com.market.services;

import com.market.models.Order_Item;

import java.util.List;

public interface OrderItemService {
    public List<Order_Item> getAllOrderItem(String id);
}
