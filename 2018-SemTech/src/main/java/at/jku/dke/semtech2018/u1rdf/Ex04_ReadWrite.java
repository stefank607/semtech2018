package at.jku.dke.semtech2018.u1rdf;

import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import java.io.File;

import org.apache.jena.rdf.model.Model;

public class Ex04_ReadWrite {

	public static void write(Model model, Lang lang) {
		System.out.println("\n\n---------"+ lang.getLabel() +"-----------------");
		RDFDataMgr.write(System.out, model, lang);
	}

	public static void main(String[] args) {


		File graphsDir = new File(Ex04_ReadWrite.class.getResource("graphs").getPath());     


		for (File file : graphsDir.listFiles()) {
			Model model = RDFDataMgr.loadModel(file.getAbsolutePath());

			System.out.println("\n\n------------------------------");
			System.out.println(" " + file.getName() + ":");
			System.out.println("------------------------------");
			write(model, Lang.TURTLE);
			write(model, Lang.NTRIPLES);
			write(model, Lang.JSONLD);
			write(model, Lang.RDFXML);
		}


	}

}
