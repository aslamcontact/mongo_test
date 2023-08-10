package com.aslam.mycontact.businesslayer;

import com.aslam.mycontact.configuration.BeanConfiguration;
import com.aslam.mycontact.daolayer.catelog.*;
import com.aslam.mycontact.daolayer.catelog.Pricing.Price;
import com.aslam.mycontact.daolayer.catelog.Pricing.PriceV1;
import com.aslam.mycontact.daolayer.catelog.quantity.NosQuantityV1;
import com.aslam.mycontact.daolayer.catelog.quantity.QuantityV1;
import com.aslam.mycontact.daolayer.catelog.variation.*;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DataAcessLogic {
    @Autowired
    private ProductRepository productRepository;

    AnnotationConfigApplicationContext beans=
            new AnnotationConfigApplicationContext(BeanConfiguration.class);


    public record Single(String type,Double price,Long quantity){};


    public Optional<Product> createProduct( String productName,
                                                String productBrand,
                                                List<String> descriptions,
                                                Map<String,String> aboutProduct,
                                                List<Single> divideProducts,
                                                String divisionName
                                            )
    {

        productBrand=productBrand.trim().toLowerCase();
        productName=productName.trim().toLowerCase();
        if(checkProduct(productName,productBrand))
            throw new IllegalStateException("Product id already Exists "+productName);

        Map<String,QuantityV1> divResult=divideProducts
                                            .stream()
                .collect(Collectors.toMap(
                                             Single::type,
                                             subQuantity->
                                                     (QuantityV1) beans.getBean(  "nos-quantity",
                                                                                   subQuantity.quantity(),
                                                                                   beans.getBean( "price",
                                                                                                   subQuantity.price()
                                                                                                 )
                                                                                )
                                         )
                        );


        VariationV1<?> variation= (VariationV1<?>) beans.getBean("single-variation",divisionName,divResult);


        Product createdProduct= (Product) beans.getBean( "product-single",
                                                         productName,
                                                         productBrand,
                                                         aboutProduct,
                                                         descriptions,
                                                         variation);


        return Optional.of(productRepository.save(createdProduct));

    }


    //create Product without any variation

    public Optional<Product> createProduct( String productName,
                                            String productBrand,
                                            Double price,
                                            Long quantity,
                                            List<String> descriptions,
                                            Map<String,String> aboutProduct)
    {

                  productBrand=productBrand.trim().toLowerCase();
                  productName=productName.trim().toLowerCase();

                  if(checkProduct(productName,productBrand))
                      throw new IllegalStateException("Product id already Stored "+productName);

                  QuantityV1 quantityAndPrice= (QuantityV1) beans.getBean("nos-quantity",
                                                             quantity,
                                                             beans.getBean("price",price)
                                                         );
                  Product createdProduct= (Product) beans.getBean( "product-none",
                                                                    productName,
                                                                    productBrand,
                                                                    aboutProduct,
                                                                    descriptions,
                                                                    quantityAndPrice);




                   return Optional.of(productRepository.save(createdProduct));

    }
    public Optional<Product> readProduct(String productName,String productBrand)
    {
        return productRepository
                .findById("Id_"+(productName+productBrand.toLowerCase().trim()));
    }
    public Product updateProduct(Product newProduct)
    {
        if(!checkProduct(newProduct.getProductName(),newProduct.getBrand()))
            throw new IllegalStateException("Check Product Name and Brand");
       return productRepository.save(newProduct);
    }

    //Delete product

    public void deleteProduct(String productName,String productBrand)
    {
        productName=productName.trim().toLowerCase();
        productBrand=productBrand.trim().toLowerCase();

        if(!checkProduct(productName,productBrand))
            throw new IllegalStateException("No Product ( "+productName+" "+productBrand+" )");

        productRepository.deleteById("Id_"+productName+productBrand);
    }




    //private methods


    private Boolean checkProduct(String productName,String brand)
    {

        return productRepository.findById("Id_"+productName+brand).isPresent();
    }










}