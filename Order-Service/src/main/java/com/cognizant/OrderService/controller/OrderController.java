package com.cognizant.OrderService.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cognizant.OrderService.configuration.OrderServiceProxy;
import com.cognizant.OrderService.model.Cart;
import com.cognizant.OrderService.model.OrderHistory;
import com.cognizant.OrderService.service.IOrderService;

@RestController
@RequestMapping("api/order")

public class OrderController {
	@Autowired
	IOrderService orderService;
	@Autowired
	OrderServiceProxy proxy;
	@Value("${server.port}")
	private int serverPort;
	
	
	
	@RequestMapping(value = "/{user}", method = RequestMethod.POST)
	public ResponseEntity<OrderHistory>	orderCartItem(@PathVariable String user) throws Exception{
		Cart cart= proxy.retrieveCart(user);
		Optional<Cart> cartItem=Optional.of(cart);
		System.out.println("User  is ---->"+cartItem.get().getUser());
		OrderHistory order =new OrderHistory();
	if(cartItem.isPresent()) {
		 order.setId(cartItem.get().getProduct());
		 order.setAmount(cartItem.get().getAmount());
		 order.setUser(cartItem.get().getUser());
		 order.setDate(new Date());
		 OrderHistory orderHistory=orderService.saveOrder(order);

		 
		 return new ResponseEntity<OrderHistory>(orderHistory, HttpStatus.OK) ;	
	}else {
		throw new Exception("user cart not found");
	}
		
		}
	
	
}
