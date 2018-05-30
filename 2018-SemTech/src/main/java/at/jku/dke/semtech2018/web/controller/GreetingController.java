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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@Autowired
	//protected org.apache.jena.rdf.model.Model m;
	protected Dataset d;
	
	//so im browser erreichbar: http://localhost:8080/index
    @GetMapping("/index")
    public String greeting(Model model) {
    	d.begin(ReadWrite.READ);  
		try {
			//Query q = QueryFactory.create("SELECT ?s ?p ?o ?g WHERE {{?s ?p ?o} UNION {GRAPH ?g {?s ?p ?o}}}");
			//Query q = QueryFactory.create("SELECT ?s ?o WHERE { ?s a <http://example.org/Skifahrer>; <http://example.org/hatGewonnen> ?o}");
			Query q = QueryFactory.create("SELECT ?nn ?vn ?wc WHERE { ?s <http://example.org/hatGewonnen> ?o; <http://example.org/hatNachnamen> ?nn; <http://example.org/hatVornamen> ?vn. ?o <http://example.org/hatBezeichnung> ?wc}");
			try (QueryExecution qEx = QueryExecutionFactory.create(q,d) ) {
				ResultSet res = qEx.execSelect();
				//ResultSetFormatter.out(System.out, res, q);
				//resstr = ResultSetFormatter.asText(res, q); //Funktioniert!! Aber Ausgabe in einem durchgehenden String
				List<QuerySolution> list = ResultSetFormatter.toList(res);
				List<String> listStr = new ArrayList<String>();
				for (QuerySolution qs : list) {
					listStr.add(qs.getLiteral("?vn").toString() + " " + qs.getLiteral("?nn").toString() + " (" + qs.getLiteral("?wc").toString() + ")");
				}
				model.addAttribute("result", listStr);
			}
		} finally { d.end(); }
        return "index";
    }
    
    @GetMapping("/index/{detail}")
    public String getDetail(@PathVariable("detail") String detail, Model model) {
    	//Splitten für Knowledge Graph
    	String[] result = detail.split(" ");
    	
    	//Testausgabe in Konsole
    	System.out.println(result[0]);
    	System.out.println(result[1]);
    	return "detail";
    }
}