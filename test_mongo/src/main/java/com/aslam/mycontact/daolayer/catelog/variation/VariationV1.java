package com.aslam.mycontact.daolayer.catelog.variation;

public interface VariationV1 {

    public PriceAndQuantity filterVariation();
    public PriceAndQuantity filterVariation(String key);
    public PriceAndQuantity filterVariation(String key1, String Key2);
}
