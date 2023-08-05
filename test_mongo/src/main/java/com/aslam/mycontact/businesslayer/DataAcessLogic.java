package com.aslam.mycontact.businesslayer;

import com.aslam.mycontact.daolayer.catelog.*;
import com.aslam.mycontact.daolayer.catelog.variation.DoubleVariation;
import com.aslam.mycontact.daolayer.catelog.variation.PriceAndQuantity;
import com.aslam.mycontact.daolayer.catelog.variation.SingleVariation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class DataAcessLogic {
    @Autowired
    private ProductRepository productRepository;

    public void productTest2() {

        SingleVariation redShirt=new SingleVariation("RedShirt"),
                        blueShirt=new SingleVariation("BlueShirt");

         redShirt.setVariations(Map.of(
                 "L",new PriceAndQuantity(627,8),
                 "M",new PriceAndQuantity(574,1),
                 "S",new PriceAndQuantity(263,5)
         )  );
        blueShirt.setVariations(Map.of(
                "L",new PriceAndQuantity(1004,12),
                "M",new PriceAndQuantity(1344,34),
                "S",new PriceAndQuantity(2444,45)
        )  );


        DoubleVariation shirt=new DoubleVariation("colors");
        shirt.setVariations(Map.of("red",redShirt,"blue",blueShirt));


        Stream.of(shirt).map(DoubleVariation::getVariations)
                .map(cr->cr.get("red"))
                .map(SingleVariation::getVariations)
                .map(size->size.get("L").getPrice())
                .forEach(System.out::println);
     System.out.println( shirt.filterVariation("red","M"));






    }



    }
