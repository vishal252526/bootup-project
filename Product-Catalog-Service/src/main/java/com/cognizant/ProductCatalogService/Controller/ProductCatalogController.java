package com.cognizant.ProductCatalogService.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ProductCatalogService.model.Product;
import com.cognizant.ProductCatalogService.model.Review;
import com.cognizant.ProductCatalogService.service.ProductCatalogService;

/**
 * @author 761514
 *
 */
/**
 * @author 761514
 *
 */
@RestController
@RequestMapping("/api/product")
public class ProductCatalogController {
@Autowired
ProductCatalogService productCatalogService;

/*
 * Method to post a single product object
 * @Author Vishal
 * @Param Product
 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		System.out.println("Inside controller------"+product.getName());
		
		return new ResponseEntity<>(productCatalogService.saveProduct(product),HttpStatus.OK);
	}
	
	/*
	 * Method to post a single product object
	 * @Author Vishal
	 * @Param List<Product>
	 */
	@RequestMapping(value = "/all", method = RequestMethod.POST)
	public ResponseEntity<List<Product>> saveProduct(@RequestBody List<Product> productList){	
		return new ResponseEntity<>(productCatalogService.saveAllProduct(productList),HttpStatus.OK);
	}
	
	/*
	 * Method to get  All product 
	 * @Author Vishal
	 *
	 */
	@RequestMapping(value="/",method = RequestMethod.GET)
	public List<Product> findAllProducts() {
		return productCatalogService.getAllProducts();
	} 
	
	/*
	 * Method to get a  product by id
	 * @Author Vishal
	 * @param id
	 *
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Optional<Product> findetProductsbyId(@PathVariable Integer id) {
		return productCatalogService.findProductsbyId(id);
	}
	
	/*
	 * Method to search product by name containing 
	 * @Author Vishal
	 * @param String criteria
	 *
	 */
	@RequestMapping(value="byName/{criteria}",method = RequestMethod.GET)
	public List<Product> findProductsbyCriteria(@PathVariable String criteria) {
		return productCatalogService.findProductsLike(criteria);
	}
	

	/*
	 * Method to get product review  by  productId 
	 * @Author Vishal
	 * @param Integer productId
	 *
	 */
	@RequestMapping(value="{productId}/review",method = RequestMethod.GET)
	public List<Review> findProductWithReviews(@PathVariable Integer productId) {
		return productCatalogService.findProductWithReviews(productId);
	}
	

	/*
	 * Method to post product reviews
	 * @Author Vishal
	 * @param Integer productId,Review.
	 *
	 */
	@RequestMapping(value = "{productId}/review", method = RequestMethod.POST)
	public ResponseEntity<Review> saveProductReview(@PathVariable Integer productId, @RequestBody Review review) throws Exception{
	
		Review reviews=productCatalogService.saveProductReview(productId,review);
		return new ResponseEntity<>(reviews,HttpStatus.OK);
	}
	
	
}
