package com.cognizant.CartService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cognizant.CartService.model.Cart;
import com.cognizant.CartService.model.FinalCartObject;
import com.cognizant.CartService.model.Item;
import com.cognizant.CartService.service.ICartService;

@RestController
@RequestMapping("api/cart")
public class CartController {
@Autowired
ICartService cartService;

@Value("${server.port}")
private int serverPort;
@RequestMapping(value = "/{user}", method = RequestMethod.POST)
public ResponseEntity<FinalCartObject>	saveCartItem(@PathVariable String user,@RequestBody FinalCartObject cartObject){
	String url="http://localhost:8082/api/price/"+cartObject.getItem().getId().toString();
	ResponseEntity<Double> responseEntity= new RestTemplate().getForEntity(url, Double.class);
	Double price=responseEntity.getBody();
	System.out.println("price of product is ---->"+price);
	Cart cart =new Cart();
	cart.setProduct(cartObject.getItem().getId());
	cart.setQuantity(cartObject.getQty());
	cart.setUser(user);
	cart.setAmount(cartObject.getQty()*price);
   cart=	cartService.saveCartItem(cart);
	Item item =cartObject.getItem();
	item.setItemTotal(cartObject.getQty()*price);
	item.setPrice(price);
	item.setUser(user);
	return new ResponseEntity<FinalCartObject>(cartObject, HttpStatus.CREATED) ;	
	}


@RequestMapping(value = "/{user}", method = RequestMethod.GET)
public ResponseEntity<Cart>	findCartItem(@PathVariable String user) throws Exception{
	System.out.println("cart service running on-->" +serverPort);
	 Cart cart=	cartService.findCartItem(user);
	return new ResponseEntity<Cart>(cart, HttpStatus.OK) ;	
	}



}
