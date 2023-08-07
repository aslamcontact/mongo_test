package com.aslam.mycontact.daolayer.catelog.variation;
import com.aslam.mycontact.daolayer.catelog.quantity.QuantityV1;

import java.util.HashMap;
import java.util.Map;

public class SingleVariation implements VariationV1 {

    private String name;

    private VariationType type;

    //variation type and price or quantity ids
    private Map<String, QuantityV1> variations;

    public SingleVariation(String name) {

        this.name=name;
        this.variations=new HashMap<>();
        this.type=VariationType.SINGLE;

    }

    public SingleVariation() {
        this.type=VariationType.SINGLE;
    }





    @Override
    public  Map<String,QuantityV1> getVariations() {
        return this.variations;
    }


    @Override
    public VariationType getType() {
        return this.type;
    }

    @Override
    public QuantityV1 getTotalQuantity() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
