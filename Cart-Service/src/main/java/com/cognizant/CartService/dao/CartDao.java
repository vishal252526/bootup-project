package com.cognizant.CartService.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.CartService.model.Cart;

@Repository
public interface CartDao extends CrudRepository<Cart, String> {

}
