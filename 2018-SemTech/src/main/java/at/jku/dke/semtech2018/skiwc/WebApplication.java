package at.jku.dke.semtech2018.skiwc;

import org.apache.jena.query.Dataset;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.vocabulary.RDFS;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import at.jku.dke.semtech2018.skiwc.SkiDataForm
;
@ComponentScan("at.jku.dke.semtech2018.web.controller")

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	@Bean
	public Dataset rdf() {
		// create an empty Model
		// Model m = ModelFactory.createDefaultModel();
		Dataset dataset = TDBFactory.assembleDataset(
				SkiWC_updateTDB.class.getResource("skiwc-assembler.ttl").getPath()) ;
		return dataset;

		// set namespace prefixes
		// m.setNsPrefix("", "http://example.org/");
		// m.setNsPrefix("rdfs", RDFS.getURI());

		// create a resource
		// Resource example = m.createResource("http://example.org/helloworld");

		// add a property
		//example.addProperty(RDFS.label, "Hello World!");
		//return m;
	}

}
