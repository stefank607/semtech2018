package at.jku.dke.semtech2018.u1rdf;

import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import org.apache.jena.rdf.model.*;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.RDFS;

public class Ex02_Graph {
	
	public static void main(String[] args) {
		//Create empty RDF Graph
		Model m = ModelFactory.createDefaultModel();
		
		//Set Namespace Prefixes
		String nsX = "http://www.example/x.rdf#";
		String nsBlack = "http://www.example/familyblack/";
		String nsFoaf = FOAF.getURI();
		m.setNsPrefix("x", nsX);
		m.setNsPrefix("black", nsBlack);
		m.setNsPrefix("foaf", nsFoaf);
		m.setNsPrefix("rdfs", RDFS.getURI());
		
		//Create Resources
		Resource jim = m.createResource(nsBlack + "jim");
		Resource john = m.createResource(nsBlack + "john");
		Property hasSon = m.createProperty(nsX + "hasSon");
		Property age = m.createProperty(nsFoaf + "age");
		Property likes = m.createProperty(nsX + "likes");
		Resource something = m.createResource();
		
		//Add Statements/Triples		
		john.addProperty(hasSon, jim);
		john.addProperty(age, m.createTypedLiteral(23));
		m.add(john, likes, something);
		
		something.addProperty(RDFS.label, m.createLiteral("Soccer","en"));
		m.add(something, RDFS.label, m.createLiteral("Fussball","de"));
		
		m.add(jim, FOAF.firstName, "Jim");
		
		//Serialize in Turtle 
		RDFDataMgr.write(System.out, m, Lang.TURTLE) ;
		
	    System.out.println("----------------------------------------------------\n");
		//      and in XML
		
	}

	
}
