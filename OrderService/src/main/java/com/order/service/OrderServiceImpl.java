package com.order.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.client.ProductService;
import com.order.entity.Order;
import com.order.model.OrderModel;
import com.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	private ProductService productService;

	@Override
	public OrderModel placeOrder(OrderModel orderModel) {
		
		productService.reduceQuantity(orderModel.getProductId(), orderModel.getQuantity());
		Order order = new Order(orderModel.getProductId(), orderModel.getAmount(), Instant.now(), "CREATED", orderModel.getQuantity());
		orderRepository.save(order);
		return orderModel;
	}

}
