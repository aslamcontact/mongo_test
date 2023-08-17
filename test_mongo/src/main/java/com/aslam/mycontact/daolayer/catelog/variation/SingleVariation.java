package com.aslam.mycontact.daolayer.catelog.variation;
import com.aslam.mycontact.daolayer.catelog.Pricing.PriceV1;
import com.aslam.mycontact.daolayer.catelog.quantity.NosQuantityV1;
import com.aslam.mycontact.daolayer.catelog.quantity.QuantityV1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class SingleVariation implements VariationV1 {

    private String name;

    private VariationType type;

    //variation type and price or quantity ids
    private Map<String, QuantityV1> variations;


    public SingleVariation()
    {
        this.variations=new HashMap<>();
        this.type=VariationType.SINGLE;
    }


    @Override
    public  Map<String,QuantityV1> getVariations() {
        return this.variations;
    }

    public void setVariations(Map<String, QuantityV1> variations) {
        this.variations = variations;
    }

    @Override
    public VariationType getType() {
        return this.type;
    }

    @Override
    public Optional<QuantityV1> getTotalQuantity() {

        Comparator<QuantityV1> finMinPrice=(prevoius,current)->
        {
           return prevoius.getPrice().getPricePerItem()
                    .compareTo(current.getPrice().getPricePerItem());

        };

       return variations.values()
                .stream()
                .filter(q -> q.getQuantity() > 0)
                .min(finMinPrice);



    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
