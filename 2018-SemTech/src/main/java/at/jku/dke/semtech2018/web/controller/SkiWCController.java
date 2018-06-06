package at.jku.dke.semtech2018.web.controller;

import java.util.ArrayList;
import java.util.Collections;
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
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SkiWCController {

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
				List<QuerySolution> list = ResultSetFormatter.toList(res);
				List<String> listStr = new ArrayList<String>();
				for (QuerySolution qs : list) {
					listStr.add(qs.getLiteral("?vn").toString() + " " + qs.getLiteral("?nn").toString() + " (" + qs.getLiteral("?wc").toString() + ")");
				}
				Collections.sort(listStr);
				model.addAttribute("result", listStr);
			}
		} finally { d.end(); }
        return "index";
    }
    
    @GetMapping("/index/{detail}")
    public String getDetail(@PathVariable("detail") String detail, Model model) {
    	//Splitten für Knowledge Graph
    	String[] result = detail.split(" ");
    	//Aufruf Knowledge graph
		org.apache.jena.rdf.model.Model rdfmod = RDFDataMgr.loadModel(
				"https://kgsearch.googleapis.com/v1/entities:search?query=" + result[0] + "+" + result[1] +"&key=AIzaSyBv-_PDRKuF2aYcnfjjWa9HxgXxIrEg_h0&limit=1&indent=True", Lang.JSONLD);

		Query q = QueryFactory.create("SELECT ?o WHERE {{ ?s <http://schema.org/articleBody> ?o } UNION { ?s <http://schema.org/description> ?o}}");
		try (QueryExecution qEx = QueryExecutionFactory.create(q,rdfmod) ) {
			ResultSet res = qEx.execSelect();
			List<QuerySolution> list = ResultSetFormatter.toList(res);
			List<String> listStr = new ArrayList<String>();
			for (QuerySolution qs : list) {
				listStr.add(qs.getLiteral("?o").toString());
			}
			Collections.reverse(listStr);
			model.addAttribute("result", listStr);
		}
		
		Query q2 = QueryFactory.create("SELECT ?o WHERE { ?s <http://schema.org/url> ?o }");
		try (QueryExecution qEx = QueryExecutionFactory.create(q2,rdfmod) ) {
			ResultSet res = qEx.execSelect();
			List<QuerySolution> list = ResultSetFormatter.toList(res);
			List<String> listLinks = new ArrayList<String>();
			for (QuerySolution qs : list) {
				listLinks.add(qs.getLiteral("?o").toString());
			}
			model.addAttribute("resultLinks", listLinks);
		}
    	return "detail";
    }
}