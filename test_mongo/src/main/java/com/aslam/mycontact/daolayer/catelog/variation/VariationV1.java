package com.aslam.mycontact.daolayer.catelog.variation;

import com.aslam.mycontact.daolayer.catelog.quantity.QuantityV1;

import java.util.Map;

public interface VariationV1<T> {
      Map<String, T> getVariations();
      String getName();
      VariationType getType();
      QuantityV1 getTotalQuantity();


}
