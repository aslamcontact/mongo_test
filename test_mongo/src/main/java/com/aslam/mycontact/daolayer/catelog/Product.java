package com.aslam.mycontact.daolayer.catelog;

import com.aslam.mycontact.daolayer.catelog.quantity.QuantityV1;
import com.aslam.mycontact.daolayer.catelog.variation.SingleVariation;
import com.aslam.mycontact.daolayer.catelog.variation.VariationType;
import com.aslam.mycontact.daolayer.catelog.variation.VariationV1;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.ConditionalOperators;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;
import java.util.stream.Stream;

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


    public Optional<QuantityV1> getQuantityAndPrice() {
        
         QuantityV1 resultVar=null;

        switch (variationType) {
            case NONE -> {
                resultVar= quantityAndPrice;
            }
            case SINGLE, DOUBLE -> {
                resultVar= variation.getTotalQuantity().get();
            }
        }
        return Optional.ofNullable(resultVar);
    }

    public void setQuantityAndPrice(QuantityV1 quantityAndPrice) {


          if(this.variationType.equals(VariationType.NONE))
             this.quantityAndPrice = quantityAndPrice;
          else throw new RuntimeException("Variation is Not None Type");

    }


    public void setVariation(VariationV1<?> variation) {
        this.setVariationType(variation.getType());
        this.variation = variation;
    }

    public VariationType getVariationType() {
        return variationType;
    }
    public VariationV1<?> getProductVariation() {
        return variation;
    }

    public void setVariationType(VariationType variationType) {

        this.variationType = variationType;
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
