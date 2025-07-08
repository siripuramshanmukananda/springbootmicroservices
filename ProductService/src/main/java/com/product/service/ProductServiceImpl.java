package com.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.exceptionhandler.ProductServiceException;
import com.product.model.ProductModel;
import com.product.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public ProductModel addProduct(ProductModel productModel) {
		Product product = new Product(productModel.getName(), productModel.getPrice(), productModel.getQuantity());
		productRepository.save(product);
		return productModel;
	}

	@Override
	public ProductModel getProductById(Long id) throws ProductServiceException {
		Product product = productRepository.findById(id).orElseThrow(() -> new ProductServiceException("Product ID Not Found", "PRODUCT_NOT_FOUND"));
		ProductModel model = new ProductModel(product.getName(), product.getPrice(), product.getQuantity());
		return model;
	}

	@Override
	public void reduceQuantity(Long id, int quantity) throws ProductServiceException {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ProductServiceException("Product ID Not Found", "PRODUCT_NOT_FOUND"));
		
		if(product instanceof Product) {
			if(product.getQuantity() < quantity) {
				throw new ProductServiceException("Not having enough quantity of products", "NOT_ENOUGH_QUANTITY");
			}
			product.setQuantity(product.getQuantity() - quantity);
			productRepository.save(product);
		}
		
		return;		
	}

}
