package at.jku.dke.semtech2018.skiwc;

import org.apache.jena.query.Dataset;
import org.apache.jena.tdb.TDBFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
;
@ComponentScan("at.jku.dke.semtech2018.web.controller")

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	@Bean
	public Dataset rdf() {
		Dataset dataset = TDBFactory.assembleDataset(
				SkiWC_updateTDB.class.getResource("skiwc-assembler.ttl").getPath()) ;
		return dataset;
	}

}
