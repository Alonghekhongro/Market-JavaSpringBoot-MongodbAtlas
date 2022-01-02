package com.market.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "product")
public class Product {
    @Id
    private String id;
    private String store_id;
    private String type_id;
    private String type_name;
    private String name;
    private Integer price;
    private String unit;
    private String status;
    private Boolean activity;
    private String url_image;
    private Date create_date;
    private Date update_date;
    private String origin;

    public Product(String store_id, String type_id,
                   String type_name, String name, String status,
                   Integer price, String url_image, String unit, String origin) {
        super();
        this.store_id = store_id;
        this.type_id = type_id;
        this.type_name = type_name;
        this.name = name;
        this.status = status;
        this.price = price;
        this.url_image = url_image;
        this.unit = unit;
        this.origin = origin;
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
    public String getType_id() {
        return type_id;
    }
    public void setType_id(String type_id) {
        this.type_id = type_id;
    }
    public String getType_name() {
        return type_name;
    }
    public void setType_name(String type_name) {
        this.type_name = type_name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public Boolean getActivity() {
        return activity;
    }
    public void setActivity(Boolean activity) {
        this.activity = activity;
    }
    public Date getCreate_date() {
        return create_date;
    }
    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
    public Date getUpdate_date() {
        return update_date;
    }
    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }
    public String getUrl_image() {
        return url_image;
    }
    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}