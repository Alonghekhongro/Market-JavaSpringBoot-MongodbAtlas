package com.egister_account.services;

import com.egister_account.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public List<Order> getAllOrder(String id);
    public boolean deleteById(String id);
}
