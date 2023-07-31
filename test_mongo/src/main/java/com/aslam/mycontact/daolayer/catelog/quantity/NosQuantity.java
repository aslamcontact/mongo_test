package com.aslam.mycontact.daolayer.catelog.quantity;

import com.aslam.mycontact.daolayer.catelog.quantity.Quantity;

public class NosQuantity implements Quantity {
    Long quantity;
    Double price;

    public NosQuantity(Long quantity, Double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
