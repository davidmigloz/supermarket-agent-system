package com.davidflex.supermarket.ontologies.ecommerce.elements;

import jade.content.Concept;

public abstract class Item implements Concept {
	private static final long serialVersionUID = 1L;

	private int quantity;
	private float price;
	private float maxPrice;
	private String status;

	public Item(int quantity, float price) {
		setQuantity(quantity);
		setPrice(price);
	}

	public Item(float maxPrice, int quantity) {
		this.maxPrice = maxPrice;
		this.quantity = quantity;
	}

	public abstract String getCategory();

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(float maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}