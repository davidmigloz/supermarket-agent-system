package com.davidflex.supermarket.ontologies.ecommerce.elements;

import java.util.List;

import jade.content.Predicate;

/**
 * The PersonalShopAgent returns a list with the available products and
 * their prices.
 */
@SuppressWarnings("unused")
public class PurchaseRespond implements Predicate {

	private List<Item> items;

	public PurchaseRespond() {
	}

	public PurchaseRespond(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItem() {
		return items;
	}

	public void setItem(List<Item> i) {
		items = i;
	}
}