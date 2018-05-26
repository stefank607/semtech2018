package at.jku.dke.semtech2018.web.controller;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
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
    	//model.addAttribute("name2", m.toString());
        //model.addAttribute("name", name);
    	String resstr;
    	d.begin(ReadWrite.READ);  
		try {
			Query q = QueryFactory.create("SELECT ?s ?p ?o ?g WHERE {{?s ?p ?o} UNION {GRAPH ?g {?s ?p ?o}}}");
			try (QueryExecution qEx = QueryExecutionFactory.create(q,d) ) {
				ResultSet res = qEx.execSelect();
				ResultSetFormatter.out(System.out, res, q);
				resstr = ResultSetFormatter.asText(res);
				model.addAttribute("result", resstr);
				//INFO Stefan: Ausgabe des  DB-Inhalts auf der Console funkioniert, an greeting.html wird leider nur die erste Zeile übergeben...
			}
		} finally { d.end(); }

		d.close();
        return "greeting";
    }

}