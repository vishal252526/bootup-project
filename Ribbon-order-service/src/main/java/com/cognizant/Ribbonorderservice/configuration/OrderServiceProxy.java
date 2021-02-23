package com.cognizant.Ribbonorderservice.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name="Cart-Service",url="localhost:8083")
@FeignClient(name="Price-proxy-Service")
@RibbonClient(name="Price-proxy-Service")
public interface OrderServiceProxy {
	@GetMapping("/api/price/port/")
	public String retrieveCart();

}
