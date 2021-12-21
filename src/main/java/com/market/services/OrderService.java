package com.market.services;

import com.market.models.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrder(String id);
    public boolean deleteById(String id);
}
