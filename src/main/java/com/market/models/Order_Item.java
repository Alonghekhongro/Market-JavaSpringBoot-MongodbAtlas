package com.market.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("order_item")
public class Order_Item {
    @Id
    private String id;
    private String order_id;
    private String product_id;
    private String product_name;
    private Integer price;
    private Integer amount;
    private Integer total;
    private Boolean cancel;
    private Date order_date;

    public Order_Item() {
        super();
    }

    public Order_Item(String id, String order_id, String product_id,
                      String product_name, Integer price, Integer amount,
                      Integer total, Boolean cancel) {
        super();
        this.order_id = order_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.amount = amount;
        this.total = total;
        this.cancel = cancel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Boolean getCancel() {
        return cancel;
    }

    public void setCancel(Boolean cancel) {
        this.cancel = cancel;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }
}
