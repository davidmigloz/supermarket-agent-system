package com.davidflex.supermarket.ontologies.ecommerce;

import jade.content.onto.BeanOntology;
import jade.content.onto.BeanOntologyException;
import jade.content.onto.Ontology;
import com.davidflex.supermarket.ontologies.ecommerce.elements.PurchaseRequest;

/**
 * ECommerceOntology.
 */
public class ECommerceOntology extends BeanOntology implements ECommerceOntologyVocabulary {

	private static final long serialVersionUID = 1L;

	// The singleton instance of this ontology
	private static Ontology instance;

	private ECommerceOntology() throws BeanOntologyException {
		super(ONTOLOGY_NAME);

		String pkgname = PurchaseRequest.class.getName();
		pkgname = pkgname.substring(0, pkgname.lastIndexOf("."));
		add(pkgname);
	}
	
	public synchronized static Ontology getInstance() throws BeanOntologyException {
		if (instance == null) {
			instance = new ECommerceOntology();
		}
		return instance;
	}
}