package at.jku.dke.semtech2018.web.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import javax.validation.Valid;

import org.apache.jena.query.Dataset;
import org.apache.jena.tdb.TDBFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import at.jku.dke.semtech2018.skiwc.SkiDataForm;
import at.jku.dke.semtech2018.skiwc.SkiWC_updateTDB;


@Controller
public class WebController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(SkiDataForm skiDataForm) {
        return "form";
    }
    
    @PostMapping ("/")
    public String commitData(@Valid SkiDataForm skiDataForm, BindingResult bindingResult) throws IOException {
		
    	//Schreibt .ru OutputFile aus eingebenen Daten in updatedTBD Folder
    	// TBD generischeFilenames + Fehlerhandling für Eingabefeld
    	SkiDataForm.writeHatGewonnen(skiDataForm.getName(), skiDataForm.getWeltCup(), skiDataForm.getProperty());
    	
    	//Update TBS-DB
		//SkiWC_updateTDB.executeUpdate(dataset, queryFile);
        
		return "redirect:/results";
    }
}