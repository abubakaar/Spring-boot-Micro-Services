package com.practice.productenquiryservice.controller;


import com.practice.productenquiryservice.beans.ProductEnquiryBean;
import com.practice.productenquiryservice.client.ProductStockClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProductEnquiryController {

    @Autowired
    ProductStockClient productStockClient;

    @GetMapping("/productenquiry/{name}/{availability}/{unit}")
    public ProductEnquiryBean getEnquiryOfProduct(@PathVariable String name,
                                                  @PathVariable String availability,
                                                  @PathVariable int unit){
        return  productStockClient.checkProductStock(name,availability);
    }
}
