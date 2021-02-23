package com.cognizant.ProductCatalogService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ProductCatalogService.dao.ProductCatalogDao;
import com.cognizant.ProductCatalogService.dao.ProductReviewDao;
import com.cognizant.ProductCatalogService.model.Product;
import com.cognizant.ProductCatalogService.model.Review;

@Service
public class ProductCatalogService {

	@Autowired
	ProductCatalogDao  productCatalogDao;
	@Autowired
	ProductReviewDao  productReviewDao;
	
	public List<Product> getAllProducts(){
		ArrayList<Product> p = new ArrayList<>();
		productCatalogDao.findAll().forEach(i -> {
			System.out.println(i.getName());
			p.add(i);
		});
		return p;

	}
	
	public Optional<Product> findProductsbyId(Integer id){
		
		return productCatalogDao.findById(id);

	}
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productCatalogDao.save(product);
	}

	public List<Product> saveAllProduct(List<Product> productList) {
		// TODO Auto-generated method stub
		ArrayList<Product> p = new ArrayList<>();
		  productCatalogDao.saveAll(productList).forEach(product->p.add(product));
		  return p;
	}

	public List<Product> findProductsLike(String criteria) {
		// TODO Auto-generated method stub
		
		return productCatalogDao.findAllByNameContainingIgnoreCase(criteria);
	}

	public List<Review> findProductWithReviews(Integer productId) {
		ArrayList<Review>al=new ArrayList<>();
		
		productReviewDao.findReviewByProductId(productId).stream().forEach(review->{
			Review rev=new Review();
			rev.setAuthor(review.getAuthor());
			rev.setBody(review.getBody());
			rev.setProduct(review.getProduct());
			al.add(review);
		});
		return al;
	}

	public Review saveProductReview(Integer productId,Review review) throws Exception {
	Optional<Product> productOptional=productCatalogDao.findById(productId);
	if(!productOptional.isPresent()) {
	throw new Exception("product not found with id --- "+productId);
	}
	review.setProduct(productOptional.get());
	return 	productReviewDao.save(review);
	}	
	
}
