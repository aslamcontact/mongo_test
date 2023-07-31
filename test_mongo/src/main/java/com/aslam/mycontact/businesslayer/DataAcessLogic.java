package com.aslam.mycontact.businesslayer;

import com.aslam.mycontact.daolayer.productdocument.*;
import com.aslam.mycontact.daolayer.productdocument.variation.MultipleVariation;
import com.aslam.mycontact.daolayer.productdocument.variation.SingleVariation;
import com.aslam.mycontact.daolayer.productdocument.variation.Variation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataAcessLogic {
    @Autowired
    private ProductRepository productRepository;
/*
    public void productTest1()
    {
       Product shirt=createProduct("Roadsted shirt",
                                    List.of("myntras brand","all new design")
                                  );

       Attribute<ProductQuantity> shirtAttribute=createAttribute( Map.of(
                                             "L",new ProductQuantity(12L),
                                             "M",new ProductQuantity(5L),
                                             "S",new ProductQuantity(7L)
                                            ),
                                        "Size"
                                      );
       Attribute<Attribute> shirtColors=createAttribute( Map.of(
                                                 "red",shirtAttribute,
                                                 "blue",shirtAttribute

               ),
               "colors"

       );

       shirt.setProductAttributes(shirtColors);
       productRepository.save(shirt);


    }

    private Product createProduct(String productName,List<String> descriptions)
    {

        return new Product(productName,descriptions);
    }

    private <T> Attribute<T> createAttribute(Map<String,T> values,String name)
    {
        return new Attribute<T>(name,values);
    }
*/


    public void productTest2() {


        Product shirt=new Product();
        shirt.setProductName("roadstershird");
        Variation maleSize=new SingleVariation<NosQuantity>("Size");
        maleSize.setValues(Map.of(
                             "L",new NosQuantity(5L,834.0),
                             "M",new NosQuantity(20L,540.0),
                             "S",new NosQuantity(8L,278.0)
                              )
        );

        Variation femaleSize=new SingleVariation<NosQuantity>("Size");
        femaleSize.setValues(Map.of(
                        "L",new NosQuantity(5L,8344.0),
                        "M",new NosQuantity(50L,5455.0),
                        "S",new NosQuantity(55L,2568.0)
                )
        );


        Variation gender=new MultipleVariation<SingleVariation<NosQuantity>>("Gender");
        gender.setValues(
                    Map.of("male",maleSize,
                    "female",femaleSize
                    )
        );
        shirt.setVariation(gender);

      productRepository.save(shirt);

    }
}
