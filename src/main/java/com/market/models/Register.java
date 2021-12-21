package com.market.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "register")
public class Register {
    @Id
    private String id;
    @Field("store_name")
    private String store_name;
    @Field("phone")
    private String phone;
    @Field("email")
    private String email;
    @Field("person_name")
    private String person_name;
    @Field("person_phone")
    private String person_phone;
    @Field("region")
    private String region;
    @Field("activity")
    private Boolean activity;
    @Field("address")
    private String address;
    @Field("url_image")
    private String url_image;
    @Field("create_date")
    private Date create_date;
    @Field("update_date")
    private Date update_date;

    public Register() {
        super();
    }

    public Register(String store_name, String phone, String email,
                    String person_name, String person_phone, String region,
                    String address, String url_image) {
        super();
        this.store_name = store_name;
        this.phone = phone;
        this.email = email;
        this.person_name = person_name;
        this.person_phone = person_phone;
        this.region = region;
        this.address = address;
        this.url_image = url_image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getPerson_phone() {
        return person_phone;
    }

    public void setPerson_phone(String person_phone) {
        this.person_phone = person_phone;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Boolean getActivity() {
        return activity;
    }

    public void setActivity(Boolean activity) {
        this.activity = activity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
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
}
