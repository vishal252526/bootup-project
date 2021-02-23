package com.cognizant.ProductCatalogService.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ProductCatalogService.model.Review;

@Repository
public interface ProductReviewDao extends CrudRepository<Review, Integer>{
	public List<Review> findReviewByProductId(Integer productId);
	//public Review savaReviewByProductId(Integer productId,Review review);

}
