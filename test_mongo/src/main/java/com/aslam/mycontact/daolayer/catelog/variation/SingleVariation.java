package com.aslam.mycontact.daolayer.catelog.variation;

import java.util.Map;

public class SingleVariation extends NoVariation {

    private String variationName;
    private Map<String, PriceAndQuantity> variations;

    public SingleVariation(String variationName) {
        this.variationName=variationName;
        setPriceAndQuenty(new PriceAndQuantity(345,5));

    }

  public PriceAndQuantity filterVariation(String key)
  {
      return variations.get(key);
  }

    public Map<String, PriceAndQuantity> getVariations() {
        return variations;
    }

    public void setVariations(Map<String, PriceAndQuantity> variations) {
        this.variations = variations;
    }


}
