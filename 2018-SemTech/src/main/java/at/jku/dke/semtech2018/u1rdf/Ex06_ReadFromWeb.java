package at.jku.dke.semtech2018.u1rdf;

import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.rdf.model.Model;

public class Ex06_ReadFromWeb {

	public static void main(String[] args) {
	
	
		Model model = RDFDataMgr.loadModel(
				"http://de.dbpedia.org/resource/Linz");
		RDFDataMgr.read(model, 
				"http://de.dbpedia.org/resource/Salzburg") ;
		
		RDFDataMgr.write(System.out, model, Lang.TURTLE);

	}

}
