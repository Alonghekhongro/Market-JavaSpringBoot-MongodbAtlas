package com.market.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document ("order")
public class Order {
    @Id
    private String id;
    private String store_id;
    private String customer_id;
    private String customer_name;
    private String customer_phone;
    private String customer_address;
    private String customer_region;
    private String time;
    private Date order_date;
    private String payment_type;
    private int total_amount;
    private int shipping_fee;
    private int total;
    private String status;
    private Boolean cancel;
    private Boolean activity;

    public Order() {super();}
    public Order(String store_id, String customer_id,
                 String customer_name, String customer_phone, String customer_address,
                 String customer_region, String time, String payment_type,
                 int total_amount, int shipping_fee, int total, String status, Boolean cancel,
                 Boolean activity) {
        super();
        this.store_id = store_id;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_phone = customer_phone;
        this.customer_address = customer_address;
        this.customer_region = customer_region;
        this.time = time;
        this.payment_type = payment_type;
        this.total_amount = total_amount;
        this.shipping_fee = shipping_fee;
        this.total = total;
        this.status = status;
        this.cancel = cancel;
        this.activity = activity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_region() {
        return customer_region;
    }

    public void setCustomer_region(String customer_region) {
        this.customer_region = customer_region;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public int getShipping_fee() {
        return shipping_fee;
    }

    public void setShipping_fee(int shipping_fee) {
        this.shipping_fee = shipping_fee;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getCancel() {
        return cancel;
    }

    public void setCancel(Boolean cancel) {
        this.cancel = cancel;
    }

    public Boolean getActivity() {
        return activity;
    }

    public void setActivity(Boolean activity) {
        this.activity = activity;
    }
}
