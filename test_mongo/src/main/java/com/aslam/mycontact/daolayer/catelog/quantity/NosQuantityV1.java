package com.aslam.mycontact.daolayer.catelog.quantity;

import com.aslam.mycontact.daolayer.catelog.Pricing.PriceV1;
import org.springframework.beans.factory.annotation.Autowired;

public class NosQuantityV1 implements QuantityV1 {
    Long quantity;

    PriceV1 price;
    public NosQuantityV1(Long quantity,   PriceV1 price) {
        this.quantity = quantity;
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public PriceV1 getPrice() {
        return price;
    }

    public void setPrice(PriceV1 price) {
        this.price = price;
    }
}
