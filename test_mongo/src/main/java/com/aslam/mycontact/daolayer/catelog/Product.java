package com.aslam.mycontact.daolayer.catelog;

import com.aslam.mycontact.daolayer.catelog.quantity.QuantityV1;
import com.aslam.mycontact.daolayer.catelog.variation.VariationType;
import com.aslam.mycontact.daolayer.catelog.variation.VariationV1;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document
public class Product {

    @Id
   private String productName;
   private List<String> productDescription;

   private VariationV1<?> variation;

   private  VariationType variationType;

   private QuantityV1 quantityAndPrice;

    public Product(String productName) {
        this.productName = productName;
        this.variationType=VariationType.NONE;

    }

    public Product() {

    }

    public VariationType getVariationType() {
        return variationType;
    }

    public void setVariationType(VariationType variationType) {

        this.variationType = variationType;
    }

    public QuantityV1 getQuantityAndPrice() {
        return quantityAndPrice;
    }

    public void setQuantityAndPrice(QuantityV1 quantityAndPrice) {
          if(this.variationType.equals(VariationType.NONE))
             this.quantityAndPrice = quantityAndPrice;
          else throw new RuntimeException("Variation is Not None Type");

    }

    public VariationV1<?> getProductVariation() {
        return variation;
    }

    public void setVariation(VariationV1<?> variation) {
        this.setVariationType(variation.getType());
        this.variation = variation;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<String> getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(List<String> productDescription) {
        this.productDescription = productDescription;
    }


}
