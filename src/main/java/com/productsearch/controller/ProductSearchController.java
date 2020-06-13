package com.productsearch.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productsearch.exception.ResourceNotFoundException;
import com.productsearch.model.Product;
import com.productsearch.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductSearchController {
	@Autowired
	private ProductService productService;

	@GetMapping("/all_products")
	public List<Product> getAllProducts() {
		return productService.getAllProductsList();
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getproductById(@PathVariable(value = "id") int productId)
			throws ResourceNotFoundException {
		Product product =  productService.getproductById(productId).orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + productId));
		return ResponseEntity.ok().body(product);
	}
	
	@GetMapping("/productname/{name}")
	public ResponseEntity<Product> getProductDetailsByName(@PathVariable(value = "name") String productName)
			throws ResourceNotFoundException {
		Product product = productService.findByProductName(productName)
				.orElseThrow(() -> new ResourceNotFoundException("product not found for this Name :: " + productName));
		return ResponseEntity.ok().body(product);
	}
	
	@GetMapping("/products/rating")
	public ResponseEntity<List<Product>> getProductsByRating(@RequestParam(name = "rating") String rating)
			throws ResourceNotFoundException {
		List<Product> productlist = productService.findByProductRating(rating);
		if(productlist.isEmpty())
			throw new ResourceNotFoundException("product or products not found for this rating :: " + rating);
		return ResponseEntity.ok().body(productlist);
	}

	
	
}
