package com.aslam.mycontact.businesslayer;

import com.aslam.mycontact.daolayer.catelog.*;
import com.aslam.mycontact.daolayer.catelog.quantity.NosQuantity;
import com.aslam.mycontact.daolayer.catelog.variation.MultipleVariation;
import com.aslam.mycontact.daolayer.catelog.variation.SingleVariation;
import com.aslam.mycontact.daolayer.catelog.variation.Variation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataAcessLogic {
    @Autowired
    private ProductRepository productRepository;

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
