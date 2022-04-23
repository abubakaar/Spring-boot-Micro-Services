package com.practice.productenquiryservice.client;

import com.practice.productenquiryservice.beans.ProductEnquiryBean;
import com.practice.productenquiryservice.configuration.LoadBalanceConfig;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name = "Stock-Service", url = "http://localhost:8800")
@FeignClient(name = "Stock-Service")
//@LoadBalancerClient(name = "Stock-Service", configuration = LoadBalanceConfig.class)
public interface ProductStockClient {

    @GetMapping("/checkproductstck/{productName}/{productAvailability}")
    public ProductEnquiryBean checkProductStock(@PathVariable String productName, @PathVariable String productAvailability);

}
