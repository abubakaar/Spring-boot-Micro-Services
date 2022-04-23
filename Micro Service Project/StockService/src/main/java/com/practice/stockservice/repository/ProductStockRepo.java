package com.practice.stockservice.repository;

import com.practice.stockservice.entity.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStockRepo extends JpaRepository<ProductStock,Long> {

    ProductStock findByProductNameAndProductAvailability(String productName, String ProductAvailability);


}
