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
        //shirt with NONE Variation
        Product shirt=new Product("Roadster");
        Price price=new Price(550D);
        shirt.setProductDescription(List.of("wash able","no hand wash"));
        NosQuantityV1 shirtQuqntity=new NosQuantityV1(5L,price);
        shirt.setQuantityAndPrice(shirtQuqntity);
// shirt with singleVar
        Product shirtOtto=new Product("Otto");
        shirtOtto.setProductDescription(List.of("Otto Brand","No Fad "));

        SingleVariation ottoShirtSize=new SingleVariation("Size");
        NosQuantityV1 lSize=new NosQuantityV1(11L,new Price(500.5));
        NosQuantityV1 sSize=new NosQuantityV1(6L,new Price(3458.6));
        NosQuantityV1 mSize=new NosQuantityV1(3L,new Price(355.6));

        ottoShirtSize.setVariations(Map.of(
                "L",lSize,
                "S",sSize,
                "M",mSize
        ));
       shirtOtto.setVariation(ottoShirtSize);

       //shitr for Dduble variation

        Product shirtAdidas=new Product("Adidas");
        shirtOtto.setProductDescription(List.of("Adidas  Brand","High Quality "));
        DoubleVariation colorSize=new DoubleVariation("Color");

        SingleVariation redColor=new SingleVariation("Size");
        redColor.setVariations(Map.of(
                 "L",new  NosQuantityV1(15L,new Price(50.5)),
                 "M",new NosQuantityV1(65L,new Price(3458.6)),
                 "S",new NosQuantityV1(34L,new Price(355.6))
        ));

        SingleVariation blueColor=new SingleVariation("Size");
        blueColor.setVariations(Map.of(
                "L",new  NosQuantityV1(13L,new Price(50.5)),
                "M",new NosQuantityV1(7L,new Price(3.6)),
                "S",new NosQuantityV1(1L,new Price(23.6))
        ));


        colorSize.setVariations(Map.of("red",redColor,"blue",blueColor));
        shirtAdidas.setVariation(colorSize);



        System.out.println(shirt.getQuantityAndPrice().get().toString());
        System.out.println(shirtOtto.getQuantityAndPrice().get().toString());
        System.out.println(shirtAdidas.getQuantityAndPrice().get().toString());
        productRepository.save(shirt);
        productRepository.save(shirtOtto);
        productRepository.save(shirtAdidas);







    }
}