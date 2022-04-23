package com.practice.stockservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductStock {

    @Id
    private Long id;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_price" )
    private BigDecimal productPrice;
    @Column(name = "product_availability")
    private String productAvailability;
    @Column(name = "product_discountoffer")
    private double discountOffer;
}
