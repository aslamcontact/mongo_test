package com.aslam.mycontact.configuration;

import com.aslam.mycontact.daolayer.catelog.Pricing.Price;
import com.aslam.mycontact.daolayer.catelog.Pricing.PriceV1;
import com.aslam.mycontact.daolayer.catelog.Product;
import com.aslam.mycontact.daolayer.catelog.quantity.NosQuantityV1;
import com.aslam.mycontact.daolayer.catelog.quantity.QuantityV1;
import com.aslam.mycontact.daolayer.catelog.variation.DoubleVariation;
import com.aslam.mycontact.daolayer.catelog.variation.SingleVariation;
import com.aslam.mycontact.daolayer.catelog.variation.VariationV1;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Configuration
public class BeanConfiguration {

    @Bean("price")
    @Scope("prototype")
    public Price price(Double price)
    {
        return new Price(price);
    }
    @Bean(name="nos-quantity")
    @Scope("prototype")
    public QuantityV1 nosQuantity(Long quantity, PriceV1 price)
    {
        return new NosQuantityV1(quantity ,price);
    }

    @Bean("single-variation")
    @Scope("prototype")
    public SingleVariation singleVariation(String name,
                                           Map<String ,QuantityV1> subVar)
    {
        SingleVariation variation=new SingleVariation();
        variation.setName(name);
        variation.setVariations(subVar);
        return variation;
    }

    @Bean("double-variation")
    @Scope("prototype")
    public DoubleVariation doubleVariation(String name)
    {
        DoubleVariation variation=new DoubleVariation();
        variation.setName(name);
        return  variation;
    }


    @Bean("product-none")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)

    public Product productNone( String name,
                                  String brand,
                                  Map<String,String> about,
                                  List<String> description,
                                  QuantityV1 quantity)
    {
        Product product=new Product(name,brand,about,description);
        product.setQuantityAndPrice(quantity);
        return product;
    }

    @Bean("product-single")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)

    public Product productSingle( String name,
                               String brand,
                               Map<String,String> about,
                               List<String> description,
                               VariationV1<?> variations)
    {
        Product product=new Product(name,brand,about,description);
        product.setVariation(variations);
        return product;
    }



}
