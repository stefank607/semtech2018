package at.jku.dke.semtech2018.u1rdf;

import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.RDFS;

public class Ex01_HelloWorld {

	public static void main(String[] args) {

		// create an empty Model
		Model m = ModelFactory.createDefaultModel();

		// set namespace prefixes
		m.setNsPrefix("", "http://example.org/");
		m.setNsPrefix("rdfs", RDFS.getURI());
		
		// create a resource
		Resource example = m.createResource("http://example.org/helloworld");

		// add a property
		example.addProperty(RDFS.label, "Hello World!");

		// write in turtle notation
		RDFDataMgr.write(System.out, m, Lang.TURTLE);
		
	}
}

