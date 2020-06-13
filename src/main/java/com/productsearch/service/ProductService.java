package com.productsearch.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.productsearch.model.Product;

@Service
public class ProductService {
	
	private List<Product> productList = new ArrayList<>(Arrays.asList(

            new Product(1, "Sony", "Sony 4k TV","image1", "4", "TV"),
            new Product(2, "LG", "LG 4k TV", "image2","4", "TV"),
            new Product(3, "Samsung", "Sony 4k TV", "image3","3.5", "TV" )

    ));

	public List<Product> getAllProductsList() {
		return productList;
	}

	public Optional<Product> getproductById(int productId) {
		return productList.stream().filter(product ->product.getId() == productId).findFirst();
	}

	public Optional<Product> findByProductName(String productName) {
		return productList.stream().filter(product ->product.getProductName().equalsIgnoreCase(productName)).findFirst();
	}

	public List<Product> findByProductRating(String rating) {
		
		 return productList.stream().filter(product ->product.getRating().equalsIgnoreCase(rating)).collect(Collectors.toList());
	}
	

}
