package com.cognizant.CartService.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.CartService.dao.CartDao;
import com.cognizant.CartService.model.Cart;
import com.cognizant.CartService.model.Item;

@Service
public class CartServiceImpl implements ICartService {

	@Autowired 
	CartDao cartDao;

	@Override
	
	public Cart saveCartItem(Cart cart) {
	cart= cartDao.save(cart);
		return cart= cartDao.save(cart);
	}

	@Override
	public Cart findCartItem(String user) throws Exception {
		// TODO Auto-generated method stub
		Optional<Cart>  cartItem=cartDao.findById(user);
		if(!cartItem.isPresent()) {
			throw new Exception("item Not found in the cart");
		}
		cartDao.deleteById(cartItem.get().getUser());
		return cartItem.get();
	}

	@Override
	public void deleteCartItem(String user) {
	
	}
	
}
