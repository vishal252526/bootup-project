package com.cognizant.PriceService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.PriceService.service.IPriceService;

@RestController
@RequestMapping("api/price/")
public class PriceController {
	@Autowired
	IPriceService priceService;
	@RequestMapping(value = "{productId}", method = RequestMethod.GET)
	public Double findProductPriceyId(@PathVariable Integer productId) throws Exception {
		return priceService.findProductPricebyId(productId);
		
	}

}
