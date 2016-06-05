package com.davidflex.supermarket.ontologies.wine.elements;

import com.davidflex.supermarket.ontologies.wine.WineOntologyVocabulary;

public class FerrerBobet extends WineItem {
	private static final long serialVersionUID = 1L;
	
	public FerrerBobet(int quantity, float price) {
		super(quantity, price);
	}

	public FerrerBobet(float maxPrice, int quantity) {
		super(maxPrice, quantity);
	}

	@Override
	public String toString() {
		return WineOntologyVocabulary.FERRER;
	}
}