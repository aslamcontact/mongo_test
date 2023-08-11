package com.aslam.mycontact.businesslayer;

import com.aslam.mycontact.configuration.BeanConfiguration;
import com.aslam.mycontact.daolayer.catelog.*;
import com.aslam.mycontact.daolayer.catelog.quantity.QuantityV1;
import com.aslam.mycontact.daolayer.catelog.variation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductDataService {
    @Autowired
    private ProductRepository productRepository;

    AnnotationConfigApplicationContext beans=
            new AnnotationConfigApplicationContext(BeanConfiguration.class);


    public record DoubleDivision(String mainDivName,String subDivName,List<SubDiv> subDivs){};
    public record SubDiv(String divideValue,Double price,Long quantity){};
    public record SingleDivision(String divideValue, Double price, Long quantity){};
    public record  None(Long Quantity,Double price){};





    public Optional<Product> createProduct(     String productName,
                                                String productBrand,
                                                List<String> descriptions,
                                                Map<String,String> aboutProduct,
                                                String divisionName,
                                                List<DoubleDivision> divideProducts

    )
    {
        final String quantityBean="nos-quantity";
        final String priceBean="price";
        final String subDivBean="single-variation";
        final String mainDivBean="double-variation";
        productBrand=productBrand.trim().toLowerCase();
        productName=productName.trim().toLowerCase();

        if(checkProduct(productName,productBrand))
            throw new IllegalStateException("Product id already Exists "+productName);

        Map<String,SingleVariation> divResult=divideProducts
                .stream()
                .collect(Collectors.toMap(
                                          DoubleDivision::mainDivName,
                                          (nextLevel)-> (SingleVariation) beans.getBean(subDivBean,
                                                               nextLevel.subDivName(),
                                                               nextLevel.subDivs().stream()
                                                               .collect(Collectors.toMap(SubDiv::divideValue,
                                                                       q->beans.getBean(  quantityBean,
                                                                                           q.quantity(),
                                                                                           beans.getBean(priceBean,
                                                                                                          q.price()))))
                                                  )


                        )


                  );





        VariationV1<?> variation= (VariationV1<?>) beans.getBean(mainDivBean,divisionName,divResult);


        Product createdProduct= (Product) beans.getBean( "product-single",
                productName,
                productBrand,
                aboutProduct,
                descriptions,
                variation);


        return Optional.of(productRepository.save(createdProduct));

    }



    //create product with sub Category

    public Optional<Product> createProduct(     String productName,
                                                String productBrand,
                                                List<String> descriptions,
                                                Map<String,String> aboutProduct,
                                                List<SingleDivision> divideProducts,
                                                String divisionName
                                            )
    {

        productBrand=productBrand.trim().toLowerCase();
        productName=productName.trim().toLowerCase();
        if(checkProduct(productName,productBrand))
            throw new IllegalStateException("Product id already Exists "+productName);

        Map<String,QuantityV1> divResult=divideProducts
                                            .stream()
                                            .collect( Collectors.toMap(
                                                      SingleDivision::divideValue,
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


    //create Product without Category

    public Optional<Product> createProduct( String productName,
                                            String productBrand,
                                            None priceQuantity,
                                            List<String> descriptions,
                                            Map<String,String> aboutProduct)
    {

                  productBrand=productBrand.trim().toLowerCase();
                  productName=productName.trim().toLowerCase();

                  if(checkProduct(productName,productBrand))
                      throw new IllegalStateException("Product id already Stored "+productName);

                  QuantityV1 quantity= (QuantityV1) beans.getBean("nos-quantity",
                                                             priceQuantity.Quantity(),
                                                             beans.getBean("price",priceQuantity.price())
                                                         );
                  Product createdProduct= (Product) beans.getBean( "product-none",
                                                                    productName,
                                                                    productBrand,
                                                                    aboutProduct,
                                                                    descriptions,
                                                                    quantity);




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