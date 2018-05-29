package at.jku.dke.semtech2018.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@Autowired
	//protected org.apache.jena.rdf.model.Model m;
	protected Dataset d;
	
    @GetMapping("/greeting")
    //public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    	String resstr = "";
    	d.begin(ReadWrite.READ);  
		try {
			//Query q = QueryFactory.create("SELECT ?s ?p ?o ?g WHERE {{?s ?p ?o} UNION {GRAPH ?g {?s ?p ?o}}}");
			Query q = QueryFactory.create("SELECT ?s ?o WHERE { ?s a <http://example.org/Skifahrer>; <http://example.org/hatGewonnen> ?o}");
			try (QueryExecution qEx = QueryExecutionFactory.create(q,d) ) {
				ResultSet res = qEx.execSelect();
				//ResultSetFormatter.out(System.out, res, q);
				//resstr = ResultSetFormatter.asText(res, q); //Funktioniert!! Aber Ausgabe in einem durchgehenden String
				List<QuerySolution> list = ResultSetFormatter.toList(res);
				List<String> listStr = new ArrayList<String>();
				for (QuerySolution qs : list) {
					//resstr = resstr + qs.toString();
					listStr.add(qs.toString());
					System.out.println(qs.toString());
				}
				//model.addAttribute("result", resstr);
				model.addAttribute("result", listStr);
			}
		} finally { d.end(); }

		d.close();
        return "greeting";
    }

}