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

import org.apache.jena.atlas.lib.StrUtils;
import org.apache.jena.query.Dataset;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.sparql.sse.SSE;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.tdb.base.file.Location;
import org.apache.jena.riot.Lang;
import org.apache.jena.update.GraphStore;
import org.apache.jena.update.GraphStoreFactory;
import org.apache.jena.update.UpdateAction;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;


import at.jku.dke.semtech2018.u3sparqlupdate.C1_UpdateModel;
import at.jku.dke.semtech2018.u3sparqlupdate.C2_QueryDataset;


public class SkiDataForm {

    @NotNull
    @Size(min=2, max=30)
    private String subject;
    private String object;
    private String type1;
    private String type2;
    private int jahr;
    public String property;

    
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
        return this.subject;
    }

    public void setName(String name) {
        this.subject = name;
    }

	public String getWeltCup() {
		return object;
	}

	public void setWeltCup(String weltCup) {
		this.object = weltCup;
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

	public static void writeHatGewonnen(String subject, String object, String property) throws IOException {
		
		Dataset dataset = TDBFactory.assembleDataset(
		SkiWC_updateTDB.class.getResource("skiwc-assembler.ttl").getPath()) ;
	
		/*
		 * Hier wird noch property 2 manuell gesetzt!!! 
		 * Dies sollte automatisch aus dem Konstruktor oben entnommen werden
		 */
		
		//String property2 = "hatGewonnen";
		
		String lineHatVornamen = 	
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n" + 
				"PREFIX : <http://example.org/> \n" + 
				"PREFIX rdfs:    <http://www.w3.org/2000/01/rdf-schema#> \n" +
				"INSERT DATA { \n" + 
				"	:" + subject + " :" + property + " \"" + object + "\"\n};";
		
		String lineHatNachnamen = 	
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n" + 
				"PREFIX : <http://example.org/> \n" + 
				"PREFIX rdfs:    <http://www.w3.org/2000/01/rdf-schema#> \n" +
				"INSERT DATA { \n" + 
				"	:" + subject + " :" + property + " \"" + object + "\"\n};";
		
		String lineHatGewonnen = 	
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n" + 
				"PREFIX : <http://example.org/> \n" + 
				"PREFIX rdfs:    <http://www.w3.org/2000/01/rdf-schema#> \n" +
				"INSERT DATA { \n"+
				"	:" + object + " a :Weltcup. \n" +
				"}; \n" +
				
				"INSERT DATA { \n" + 
				"	:" + subject + "  a :Skifahrer. \n" + 
				"};\n" +
				"INSERT DATA { \n" + 
				"	:" + subject + " :" + property + " :" + object + ".\n};";
		
		String lineHatStattgefunden = 	
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n" + 
						"PREFIX : <http://example.org/> \n" + 
						"PREFIX rdfs:    <http://www.w3.org/2000/01/rdf-schema#> \n" +
						"INSERT DATA { \n" + 
						"	:" + subject + " :" + property + " :" + object + ".\n};";
		
		
		String lineHatBezeichnung = 	
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n" + 
						"PREFIX : <http://example.org/> \n" + 
						"PREFIX rdfs:    <http://www.w3.org/2000/01/rdf-schema#> \n" +
						"INSERT DATA { \n" + 
						"	:" + subject + " :" + property + " \"" + object + "\"\n};";
		
		
	     /*
	      * ... perform a SPARQL Update https://jena.apache.org/documentation/tdb/tdb_transactions.html
	      * 
	      *  Anmerkung: Hier wird nun das wirkliche update durchgeführt auf den Triplestore
	      *  
	      *  Bitte wenn möglich den auskommentierten Teil noch lassen für etwaige Probleme. 
	      *  Ich lösche das dann alles vor Abgabe
	      *  
	      *  String p1 = "hatGewonnen";
        	String p2 = "hatVornamen";
        	String p3 = "hatNachnamen";
        	String p4 = "hatStattgefunden";
        	String p5 = "hatBezeichnung";
	      *  
	      */
		
		
	     if(property.equals("hatGewonnen")){
	    	 try {
	    	 dataset.begin(ReadWrite.WRITE) ;
		     GraphStore graphStore = GraphStoreFactory.create(dataset) ;
	    	 System.out.println("gewonnen: \n" + lineHatGewonnen);
	    	 String sparqlUpdateString = StrUtils.strjoinNL(lineHatGewonnen) ;     
		     UpdateRequest request = UpdateFactory.create(sparqlUpdateString) ;
		     UpdateProcessor proc = UpdateExecutionFactory.create(request, graphStore) ;
		     proc.execute();
		  // Finally, commit the transaction.
		     dataset.commit() ;
	    	 } finally {
		     dataset.end() ; 
	    	 }

	     }
	     else if(property.equals("hatStattgefunden")){
	    	 try {
	    	 dataset.begin(ReadWrite.WRITE) ;
		     GraphStore graphStore = GraphStoreFactory.create(dataset) ;
	    	 System.out.println(lineHatStattgefunden);
	    	 String sparqlUpdateString = StrUtils.strjoinNL(lineHatStattgefunden) ;     
		     UpdateRequest request = UpdateFactory.create(sparqlUpdateString) ;
		     UpdateProcessor proc = UpdateExecutionFactory.create(request, graphStore) ;
		     proc.execute();
		  // Finally, commit the transaction.
		     dataset.commit() ;
	    	 } finally {
			 dataset.end() ; 
	    	 }

	     }
	     else if(property.equals("hatVornamen")){
	    	 try {
	    	 dataset.begin(ReadWrite.WRITE) ;
		     GraphStore graphStore = GraphStoreFactory.create(dataset) ;
	    	 System.out.println(lineHatVornamen);
	    	 String sparqlUpdateString = StrUtils.strjoinNL(lineHatVornamen) ;     
		     UpdateRequest request = UpdateFactory.create(sparqlUpdateString) ;
		     UpdateProcessor proc = UpdateExecutionFactory.create(request, graphStore) ;
		     proc.execute();
		  // Finally, commit the transaction.
		     dataset.commit() ;
	    	 } finally {
		     dataset.end() ; 
	    	 }
	     }
	     else if(property.equals("hatNachnamen")){
	    	 try {
	    	 dataset.begin(ReadWrite.WRITE) ;
		     GraphStore graphStore = GraphStoreFactory.create(dataset) ;
	    	 System.out.println(property);
	    	 System.out.println(lineHatNachnamen);
	    	 String sparqlUpdateString = StrUtils.strjoinNL(lineHatNachnamen) ;     
		     UpdateRequest request = UpdateFactory.create(sparqlUpdateString) ;
		     UpdateProcessor proc = UpdateExecutionFactory.create(request, graphStore) ;
		     proc.execute();
		  // Finally, commit the transaction.
		     dataset.commit() ;
	     	 } finally {
		     dataset.end() ; 
	    	 } 

	     }
	     else if(property.equals("hatBezeichnung")) {
	    	 try {
	    	 dataset.begin(ReadWrite.WRITE) ;
		     GraphStore graphStore = GraphStoreFactory.create(dataset) ;
	    	 System.out.println("bezeichnung: " + lineHatBezeichnung + "\n");
	     	System.out.println("property: " + property);
	    	 String sparqlUpdateString = StrUtils.strjoinNL(lineHatBezeichnung) ;     
		     UpdateRequest request = UpdateFactory.create(sparqlUpdateString) ;
		     UpdateProcessor proc = UpdateExecutionFactory.create(request, graphStore) ;
		     proc.execute();	     
		     dataset.commit() ;
	    	 } finally {
			 dataset.end() ; 
		     }
	     }
		
		//File in updatesTDB schreiben
//        File file = new File("C:/dev/git/semtech2018/2018-SemTech/src/main/resources/at/jku/dke/semtech2018/skiwc/updatesTDB/" + name + property2 + weltCup + ".ru");
//        file.createNewFile();
//        FileWriter writer = new FileWriter(file); 
//        writer.write(line); 
//        writer.flush();
//        writer.close();
//		
//		Dataset dataset = TDBFactory.assembleDataset(
//				SkiWC_updateTDB.class.getResource("skiwc-assembler.ttl").getPath()) ;
		
		/*****************************************************************
		 * Insert to Graph
		 * Anmerkung: schreibt es korrekt in einen Graphstore
		 */
		// An initially empty GraphStore https://dreampromt.wordpress.com/2012/07/16/sparql-update-operations-with-jena-api/
	    //GraphStore graphStore = GraphStoreFactory.create(dataset);
        //UpdateAction.parseExecute(line, graphStore) ;
        //System.out.println("\n# Graph content");
        //SSE.write(graphStore) ;
		
        
        /*
         * Write .ru File to TripleStore Folder
         */
//        
//		File updatesDir = new File(SkiWC_updateTDB.class.getResource("updatesTDB").getPath());     
//		File[] updates = updatesDir.listFiles();
//
//		dataset.begin(ReadWrite.WRITE); // START TRANSACTION
//		try {
//			dataset.getDefaultModel().removeAll(); // delete everything from default model
//			dataset.commit();
//		} finally { dataset.end(); } // END TRANSACTION (ABORT IF NO COMMIT)
//
//		/* execute every update request in its own transaction */
//		for (int i = 0; i < updates.length; i++) {
//			dataset.begin(ReadWrite.WRITE); // START TRANSACTION
//			try {
//				executeUpdate(dataset,updates[i]);
//				dataset.commit();
//			} catch (RuntimeException e) {
//				System.out.println(e.getMessage());
//				dataset.abort(); //
//			} finally { 
//				dataset.end(); // END TRANSACTION (ABORT IF NO COMMIT)
//			} 
//		}
	}
	
}