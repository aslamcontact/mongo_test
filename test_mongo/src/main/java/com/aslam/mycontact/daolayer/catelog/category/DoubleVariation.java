package com.aslam.mycontact.daolayer.catelog.category;

import java.util.Map;

public class DoubleVariation extends SingleVariation implements VariationV1{

    private Map<String,SingleVariation> variations;


    public DoubleVariation(String variationName, Map<String, SingleVariation> variations) {
        super(variationName);

        this.variations = variations;
    }
    public PriceAndQuenty filterVariation(String key1,String key2)
    {
        return variations.get(key1).filterVariation(key2);
    }


}
