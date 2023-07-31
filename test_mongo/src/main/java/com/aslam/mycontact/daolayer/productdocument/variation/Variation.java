package com.aslam.mycontact.daolayer.productdocument.variation;

import java.util.Map;

public abstract class Variation {
    private String variationName;
    private Map<?,?> values;

    protected abstract Map<?,?> createValues();



    protected  void assignValues(String variationName) {
           this.variationName=variationName;
           this.values=createValues();

    }

    public String getVariationName() {
        return variationName;
    }

    public void setVariationName(String variationName) {
        this.variationName = variationName;
    }

     Map<?, ?> getValues() {
        return values;
    }

    public void setValues(Map<?, ?> values) {
        this.values = values;
    }
}
