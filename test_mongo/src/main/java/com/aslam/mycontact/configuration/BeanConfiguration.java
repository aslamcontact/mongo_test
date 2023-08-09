package com.aslam.mycontact.configuration;

import com.aslam.mycontact.daolayer.catelog.Pricing.Price;
import com.aslam.mycontact.daolayer.catelog.quantity.NosQuantityV1;
import com.aslam.mycontact.daolayer.catelog.variation.DoubleVariation;
import com.aslam.mycontact.daolayer.catelog.variation.SingleVariation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfiguration {

    @Bean
    @Scope("prototype")
    public Price price()
    {
        return new Price();
    }
    @Bean
    @Scope("prototype")
    public NosQuantityV1 nosQuantity()
    {
        return new NosQuantityV1();
    }

    @Bean
    @Scope("prototype")
    public SingleVariation singleVariation()
    {
        return new SingleVariation();
    }

    @Bean
    @Scope("prototype")
    public DoubleVariation doubleVariation()
    {
        return  new DoubleVariation();
    }



}
