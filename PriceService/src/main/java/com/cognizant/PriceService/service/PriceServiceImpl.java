package com.cognizant.PriceService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.PriceService.dao.PriceDao;
import com.cognizant.PriceService.model.Product;


@Service
public class PriceServiceImpl implements IPriceService {

	@Autowired
	PriceDao priceDao;

	@Override
	public Double findProductPricebyId(Integer productId) throws Exception {
		Optional<Product> product = priceDao.findById(productId);
		if (product.isEmpty()) {
			throw new Exception("product not found");
		}
		
		return product.get().getPrice();
	}
}
