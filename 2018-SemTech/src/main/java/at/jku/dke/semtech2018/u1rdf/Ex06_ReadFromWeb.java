package at.jku.dke.semtech2018.u1rdf;

import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.rdf.model.Model;

public class Ex06_ReadFromWeb {

	public static void main(String[] args) {
	
	
		Model model = RDFDataMgr.loadModel(
				"https://kgsearch.googleapis.com/v1/entities:search?query=Franz+Klammer&key=AIzaSyBv-_PDRKuF2aYcnfjjWa9HxgXxIrEg_h0&limit=1&indent=True", Lang.JSONLD);

		
		RDFDataMgr.write(System.out, model, Lang.TURTLE);

	}

}
