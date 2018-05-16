package at.jku.dke.semtech2018.u1rdf;

import org.apache.jena.rdf.model.*;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.RDF;

/*
 * siehe: http://jena.sourceforge.net/how-to/reification.html 
 */
public class Ex03_Reification {
	
	public static void main(String[] args) {
		Model m = ModelFactory.createDefaultModel();
		
		// Set Namespace-Prefixes
		String nsVoc = "http://example.org/vocabulary.rdf#";
		String nsData = "http://example.org/data.rdf#";
		m.setNsPrefix("v", nsVoc);
		m.setNsPrefix("d", nsData);
		m.setNsPrefix("rdf", RDF.getURI());
		m.setNsPrefix("foaf", FOAF.getURI());
		
		
		// Create Resources
		Resource frank = m.createResource(nsData + "Frank");
		Resource susi = m.createResource(nsData + "Susi");
		Resource john = m.createResource(nsData + "John");
		Property thinks = m.createProperty(nsVoc + "thinks");
		Property denies = m.createProperty(nsVoc + "denies");
				
		// Create Reified Statement (note: statement itself is not part of the model)
		ReifiedStatement johnKnowsSusi = 
				m.createReifiedStatement(m.createStatement(john, FOAF.knows, susi));
		
		// Create Statements	
		m.add(frank,thinks,johnKnowsSusi);
		m.add(john,denies,johnKnowsSusi);
		
		
		
		System.out.println("######## TURTLE ###########");
		
		m.write(System.out,"TURTLE");

	}
	
}
