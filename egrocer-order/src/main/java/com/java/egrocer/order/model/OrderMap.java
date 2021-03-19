package com.java.egrocer.order.model;

public class OrderMap {

	private long orderMapId;
	private long orderId;
	private long productId;
	
	public long getOrderMapId() {
		return orderMapId;
	}
	public void setOrderMapId(long orderMapId) {
		this.orderMapId = orderMapId;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
}
