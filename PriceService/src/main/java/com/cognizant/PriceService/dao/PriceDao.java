package com.cognizant.PriceService.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.PriceService.model.Product;
@Repository
public interface PriceDao extends CrudRepository<Product, Integer>  {

	 Optional<Double> findPriceById(Integer id);
		

}
