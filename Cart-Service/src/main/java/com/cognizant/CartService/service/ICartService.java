package com.cognizant.CartService.service;

import java.util.Map;

import com.cognizant.CartService.model.Cart;
import com.cognizant.CartService.model.Item;

public interface ICartService {

Cart saveCartItem(Cart cart);

Cart findCartItem(String user) throws Exception;

void deleteCartItem(String user);

	

}
