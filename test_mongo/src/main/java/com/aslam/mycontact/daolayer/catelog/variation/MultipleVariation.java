package com.aslam.mycontact.daolayer.catelog.variation;

import java.util.HashMap;
import java.util.Map;

public class MultipleVariation<T extends Variation> extends Variation{

    public MultipleVariation(String name) {
        super.assignValues(name);

    }

    @Override
    protected Map<?, ?> createValues() {
        return new HashMap<String,T>();
    }
}
