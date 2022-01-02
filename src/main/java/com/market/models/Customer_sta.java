package com.market.models;

public class Customer_sta {
    private Integer count;
    private String region;

    public Customer_sta() {
        super();
    }

    public Customer_sta(Integer count, String region) {
        super();
        this.count = count;
        this.region = region;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
