package at.jku.dke.semtech2018.u2sparqlquery;

import java.io.File;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;


public class Ex1_QueryWikidata {

   public static void main(String[] args) {      

	   /* Wikidata's SPARQL Endpoint
	    * see: https://www.wikidata.org/wiki/Wikidata:SPARQL_query_service/queries/examples
	    */
	   
      File queryFile = new File(Ex1_QueryWikidata.class.getResource("wikidataquery.rq").getPath());     
      Query query = QueryFactory.read(queryFile.getPath());
      
      try (QueryExecution qexec = 
    		  QueryExecutionFactory.sparqlService("https://query.wikidata.org/sparql", query)) {
         ResultSet results = qexec.execSelect() ;
         ResultSetFormatter.out(System.out, results, query) ;
      }          


   
   }
   
   
}
