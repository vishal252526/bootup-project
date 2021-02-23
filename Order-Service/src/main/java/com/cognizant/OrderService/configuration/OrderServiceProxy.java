package com.cognizant.OrderService.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.OrderService.model.Cart;

@FeignClient(name="Cart-Service",url="localhost:8083")
//@FeignClient(name="Cart-Service")
//@RibbonClient(name="com.cognizant.OrderService")
public interface OrderServiceProxy {
	@GetMapping("/api/cart/{user}")
	public Cart retrieveCart(@PathVariable String user);

	@DeleteMapping("/api/cart/{user}")
	public void deleteCart(@PathVariable String user);
}
