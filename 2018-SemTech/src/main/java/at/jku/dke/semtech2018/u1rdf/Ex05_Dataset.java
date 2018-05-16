package at.jku.dke.semtech2018.u1rdf;

import java.io.File;

import org.apache.jena.query.Dataset;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;


public class Ex05_Dataset {

	public static void write(Dataset dataset, Lang lang) {
		System.out.println("\n\n---------"+ lang.getLabel() +"-----------------");
		RDFDataMgr.write(System.out, dataset, lang);
	}
	
	public static void main(String[] args) {

		File graphsDir = new File(Ex05_Dataset.class.getResource("datasets").getPath());     


		for (File file : graphsDir.listFiles()) {
			Dataset dataset = RDFDataMgr.loadDataset(file.getAbsolutePath(),Lang.NQUADS);

			System.out.println("\n\n------------------------------");
			System.out.println(" " + file.getName() + ":");
			System.out.println("------------------------------");
			write(dataset, Lang.TRIG);
			write(dataset, Lang.JSONLD);
			write(dataset, Lang.NQUADS);
		}
		
	}
}
