package com.aslam.mycontact.businesslayer;

import com.aslam.mycontact.daolayer.catelog.*;
import com.aslam.mycontact.daolayer.catelog.Pricing.Price;
import com.aslam.mycontact.daolayer.catelog.quantity.NosQuantityV1;
import com.aslam.mycontact.daolayer.catelog.variation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataAcessLogic {
    @Autowired
    private ProductRepository productRepository;

    public void productTest2(){

        Product shirt=new Product("Roadster");

        shirt.setProductDescription(List.of("hand wash only","collor  fad is not our re"));
        SingleVariation size=new SingleVariation();
         shirt.setVariation(size);
        shirt.setQuantityAndPrice(
                new NosQuantityV1(23L,new Price(56.4))
        );


        productRepository.save(shirt);
      //  productRepository.save(shirt2);






    }
}