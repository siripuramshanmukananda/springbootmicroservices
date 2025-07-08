package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.exceptionhandler.ProductServiceException;
import com.product.model.ProductModel;
import com.product.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/add")
	public ProductModel addProduct(@RequestBody ProductModel productModel){
		return productService.addProduct(productModel);
	}
	
	@GetMapping("/get/{id}")
	public ProductModel getProductById(@PathVariable Long id) throws ProductServiceException {
		return productService.getProductById(id);
	}
	
	@PutMapping("/reduceQuantity/{id}")
	public ResponseEntity<Void> reduceQuantity(@PathVariable Long id, @RequestParam int quantity) throws ProductServiceException{
		productService.reduceQuantity(id, quantity);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
}
