package com.aslam.mycontact.daolayer.catelog.category;

public class PriceAndQuantity {

    private Integer price;
    private  Integer Quanty;

    public PriceAndQuantity(Integer price, Integer quanty) {
        this.price = price;
        Quanty = quanty;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuanty() {
        return Quanty;
    }

    public void setQuanty(Integer quanty) {
        Quanty = quanty;
    }
}
