package at.jku.dke.semtech2018.skiwc;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.tdb.TDBFactory;


import org.apache.jena.riot.Lang;
import org.apache.jena.update.UpdateAction;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateRequest;


import at.jku.dke.semtech2018.u3sparqlupdate.C1_UpdateModel;
import at.jku.dke.semtech2018.u3sparqlupdate.C2_QueryDataset;


public class SkiDataForm {

    @NotNull
    @Size(min=2, max=30)
    private String name;
    private String weltCup;
    private int jahr;
    private String property;

    
    public int getJahr() {
		return jahr;
	}

	public void setJahr(int jahr) {
		this.jahr = jahr;
	}

	
	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
	

	public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getWeltCup() {
		return weltCup;
	}

	public void setWeltCup(String weltCup) {
		this.weltCup = weltCup;
	}
	
	public static void executeUpdate(Dataset ds, File queryFile) {
		System.out.println("\n\n------------------------------");
		System.out.println(" " + queryFile.getName() + ":");
		System.out.println("------------------------------");
		UpdateRequest request = UpdateFactory.read(queryFile.getPath());
		System.out.println(request);
		UpdateAction.execute(request, ds) ;
		System.out.println("------------------------------");
		System.out.println(" Dataset after execution :");
		System.out.println("------------------------------");

		RDFDataMgr.write(System.out, ds, Lang.TRIG);
	}

	public static void writeHatGewonnen(String name, String weltCup, String property) throws IOException {
		
		//TBD Generisch sämtliche Relations ausgeben
		String property2 = "hatGewonnen";
		
		String line = 	
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n" + 
				"PREFIX : <http://example.org/> \n" + 
				"PREFIX rdfs:    <http://www.w3.org/2000/01/rdf-schema#> \n" +
				"INSERT DATA { \n"+
				"	:" + weltCup + " a :Weltcup. " +
				"};" +
				
				"INSERT DATA { \n" + 
				"	:" + name + "  a :Skifahrer. \n" + 
				"};\n" +
				"INSERT DATA { \n" + ":" + name + " :" + property2 + ":" + weltCup + "\n};";
		
    	//System.out.println(":" + name + " :hatGewonnen : " + weltCup);

		
		Dataset dataset = TDBFactory.assembleDataset(
				SkiWC_updateTDB.class.getResource("skiwc-assembler.ttl").getPath()) ;
		
		File updatesDir = new File(SkiWC_updateTDB.class.getResource("updatesTDB").getPath());     
		File[] updates = updatesDir.listFiles();

		dataset.begin(ReadWrite.WRITE); // START TRANSACTION
		try {
			dataset.getDefaultModel().removeAll(); // delete everything from default model
			dataset.commit();
		} finally { dataset.end(); } // END TRANSACTION (ABORT IF NO COMMIT)

		/* execute every update request in its own transaction */
		for (int i = 0; i < updates.length; i++) {
			dataset.begin(ReadWrite.WRITE); // START TRANSACTION
			try {
				executeUpdate(dataset,updates[i]);
				dataset.commit();
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
				dataset.abort(); //
			} finally { 
				dataset.end(); // END TRANSACTION (ABORT IF NO COMMIT)
			} 
		}


		
		//File in updatesTDB schreiben
        File file = new File("C:/dev/git/2018-SemTech/src/main/resources/at/jku/dke/semtech2018/skiwc/updatesTDB/update2.ru");
        file.createNewFile();
        FileWriter writer = new FileWriter(file); 
        writer.write(line); 
        writer.flush();
        writer.close();
	}
}