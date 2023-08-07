package com.aslam.mycontact.daolayer.catelog.variation;

import com.aslam.mycontact.daolayer.catelog.quantity.QuantityV1;

import java.util.HashMap;
import java.util.Map;

public class DoubleVariation implements VariationV1 {

    private String name;

    private  VariationType type;

    private Map<String, SingleVariation> variations;


    public DoubleVariation(String name) {
        this.name=name;
        this.type=VariationType.DOUBLE;
        this.variations = new HashMap<>();
    }

    public  Map<String, SingleVariation> getVariations() {
        return variations;
    }


    public String getName() {
        return name;
    }

    @Override
    public VariationType getType() {
        return this.type;
    }

    @Override
    public QuantityV1 getTotalQuantity() {
        return null;
    }


}
