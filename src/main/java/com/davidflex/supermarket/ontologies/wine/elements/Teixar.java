package com.davidflex.supermarket.ontologies.wine.elements;

import com.davidflex.supermarket.ontologies.wine.WineOntologyVocabulary;

public class Teixar extends WineItem {
	private static final long serialVersionUID = 1L;
	
	public Teixar(int quantity, float price) {
		super(quantity, price);
	}

	public Teixar(float maxPrice, int quantity) {
		super(maxPrice, quantity);
	}

	@Override
	public String toString() {
		return WineOntologyVocabulary.TEIXAR;
	}
}