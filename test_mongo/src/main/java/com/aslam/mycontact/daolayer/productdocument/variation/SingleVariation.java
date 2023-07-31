package com.aslam.mycontact.daolayer.productdocument.variation;

import com.aslam.mycontact.daolayer.productdocument.Quantity;

import java.util.HashMap;
import java.util.Map;

public class SingleVariation<T extends Quantity> extends Variation {



    public  SingleVariation(String name) {
        super.assignValues(name);


    }


    @Override
    protected  Map<?, ?> createValues() {
        return new HashMap<String,T>();
    }
}
