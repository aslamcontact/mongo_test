package com.aslam.mycontact.businesslayer;

import com.aslam.mycontact.daolayer.catelog.*;
import com.aslam.mycontact.daolayer.catelog.Pricing.Price;
import com.aslam.mycontact.daolayer.catelog.Pricing.PriceV1;
import com.aslam.mycontact.daolayer.catelog.quantity.NosQuantityV1;
import com.aslam.mycontact.daolayer.catelog.quantity.QuantityV1;
import com.aslam.mycontact.daolayer.catelog.variation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataAcessLogic {
    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> createProduct( String productName,
                               String productBrand,
                               List<String> descriptions,
                               Double price,
                               Long quantity) {

                   Product createdProduct;
                   productRepository.findById(
                           "Id_"+productName.toLowerCase()+productBrand.toLowerCase()).ifPresent(
                                   res-> {

                                          throw new IllegalStateException("Use Another product and brand name"
                                            +res.getProductName());
                                       }
                                  );

           createdProduct=newProduct( productName,
                                      productBrand,
                                      descriptions
                                     );
                   createdProduct
                  .setQuantityAndPrice(newQuantity(newPrice(price),quantity));

                   return Optional.of(productRepository.save(createdProduct));

    }
    private Product newProduct(String name,String brand,List<String> descriptions)
    {
        Product newProduct=new Product(name,brand);
        newProduct.setProductDescription(descriptions);

        return newProduct;
    }

    private PriceV1 newPrice(Double price){
        return new Price(price);
    }

    private QuantityV1 newQuantity(PriceV1 price,Long quantity)
    {
        return new NosQuantityV1(quantity,price);
    }

   private SingleVariation newSingleVariation(String name)
    {
        SingleVariation variation=new SingleVariation();
        variation.setName(name);
        return variation;
    }
    private DoubleVariation newDoubleVariation(String name)
    {
         DoubleVariation variation=new DoubleVariation();
        variation.setName(name);
        return variation;
    }
    private VariationV1<?> updateVariation(String name, Map<String,QuantityV1> variations)
    {
        SingleVariation singleVariation=newSingleVariation(name);
        singleVariation.setVariations(variations);
        return singleVariation;

    }

    private VariationV1<?> updateVariation(Map<String,SingleVariation> variations,String mainName)
    {
        DoubleVariation doubleVariation=newDoubleVariation(mainName);
        doubleVariation.setVariations(variations);
        return doubleVariation;

    }



}