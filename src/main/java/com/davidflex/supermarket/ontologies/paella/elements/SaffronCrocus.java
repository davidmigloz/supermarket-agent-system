package com.davidflex.supermarket.ontologies.paella.elements;

import com.davidflex.supermarket.ontologies.paella.PaellaOntologyVocabulary;

public class SaffronCrocus extends PaellaItem {
	private static final long serialVersionUID = 1L;
	
	public SaffronCrocus(int quantity, float price) {
		super(quantity, price);
	}

	public SaffronCrocus(float maxPrice, int quantity) {
		super(maxPrice, quantity);
	}

	@Override
	public String toString() {
		return PaellaOntologyVocabulary.SAFFRON;
	}
}