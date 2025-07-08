package com.product.service;

import com.product.exceptionhandler.ProductServiceException;
import com.product.model.ProductModel;

public interface ProductService {

	ProductModel addProduct(ProductModel productModel);

	ProductModel getProductById(Long id) throws ProductServiceException;

	void reduceQuantity(Long id, int quantity) throws ProductServiceException;

}
