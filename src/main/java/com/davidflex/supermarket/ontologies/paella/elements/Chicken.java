package com.davidflex.supermarket.ontologies.paella.elements;

import com.davidflex.supermarket.ontologies.paella.PaellaOntologyVocabulary;

public class Chicken extends PaellaItem {
	private static final long serialVersionUID = 1L;
	
	public Chicken(int quantity, float price) {
		super(quantity, price);
	}

	public Chicken(float maxPrice, int quantity) {
		super(maxPrice, quantity);
	}

	@Override
	public String toString() {
		return PaellaOntologyVocabulary.CHICKEN;
	}
}