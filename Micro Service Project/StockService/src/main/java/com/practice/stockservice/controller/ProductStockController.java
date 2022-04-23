package com.practice.stockservice.controller;


import com.practice.stockservice.beans.ProductStockBean;
import com.practice.stockservice.entity.ProductStock;
import com.practice.stockservice.repository.ProductStockRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductStockController {

    @Autowired
    private ProductStockRepo productStockRepo;

    @Autowired
    Environment environment;

    @GetMapping("/checkproductstck/{productName}/{productAvailability}")
    public ProductStockBean checkProductStock(@PathVariable String productName, @PathVariable String productAvailability)
    {
        ProductStock productStock = productStockRepo.findByProductNameAndProductAvailability(productName,productAvailability);
        ProductStockBean productStockBean = new ProductStockBean(
                productStock.getId(),
                productStock.getProductName(),
                productStock.getProductPrice(),
                productStock.getProductAvailability(),
                productStock.getDiscountOffer(),

                Integer.parseInt(environment.getProperty("local.server.port"))
        );

        return productStockBean;
    }
}
