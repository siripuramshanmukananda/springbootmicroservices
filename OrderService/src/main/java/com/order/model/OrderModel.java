package com.order.model;

public class OrderModel {

	private long productId;
	private int quantity;
	private Double amount;
	private PaymentMode paymentMode;
	
	public OrderModel() {
		
	}

	public OrderModel(long productId, int quantity, Double amount, PaymentMode paymentMode) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.amount = amount;
		this.paymentMode = paymentMode;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}
	
}
