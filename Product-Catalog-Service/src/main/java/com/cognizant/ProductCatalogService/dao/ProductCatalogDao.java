package com.cognizant.ProductCatalogService.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ProductCatalogService.model.Product;

@Repository
public interface ProductCatalogDao extends CrudRepository<Product, Integer> {
	List<Product> findAllByNameContainingIgnoreCase(String title);
}
