package com.aslam.mycontact.daolayer.catelog.category;

import java.util.Map;

public class SingleVariation extends NoVariation {

    private String variationName;
    private Map<String,PriceAndQuenty> variations;

    public SingleVariation(String variationName) {
        this.variationName=variationName;
        setPriceAndQuenty(new PriceAndQuenty(345,5));

    }

  public PriceAndQuenty filterVariation(String key)
  {
      return variations.get(key);
  }

    public Map<String, PriceAndQuenty> getVariations() {
        return variations;
    }

    public void setVariations(Map<String, PriceAndQuenty> variations) {
        this.variations = variations;
    }


}
