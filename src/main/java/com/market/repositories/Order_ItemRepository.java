package com.market.repositories;

import com.market.models.Order_Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface Order_ItemRepository extends MongoRepository<Order_Item, String> {
    @Query("{cancel: false}")
    List<Order_Item> getAllOrderItem();
}
