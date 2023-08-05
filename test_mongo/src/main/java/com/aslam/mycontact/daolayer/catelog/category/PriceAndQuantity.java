package com.aslam.mycontact.daolayer.catelog.category;

import com.sun.jdi.PrimitiveValue;

public class PriceAndQuenty {

    private Integer price;
    private  Integer Quanty;

    public PriceAndQuenty(Integer price, Integer quanty) {
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
