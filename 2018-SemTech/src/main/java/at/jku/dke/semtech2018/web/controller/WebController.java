package at.jku.dke.semtech2018.web.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import javax.validation.Valid;

import org.apache.jena.query.Dataset;
import org.apache.jena.tdb.TDBFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import at.jku.dke.semtech2018.skiwc.PredicateDAO;
import at.jku.dke.semtech2018.skiwc.SkiDataForm;
import at.jku.dke.semtech2018.skiwc.SkiWC_updateTDB;


@Controller
public class WebController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }
    
    @PostMapping ("/form")
    public String commitData(@Valid SkiDataForm skiDataForm, BindingResult bindingResult, Model model) throws IOException {
		
    	//Schreibt .ru OutputFile aus eingebenen Daten in updatedTBD Folder
    	// TBD generischeFilenames + Fehlerhandling für Eingabefeld
        SkiDataForm form = new SkiDataForm();
        model.addAttribute("skiDataForm", form);
     
        List<String> list = PredicateDAO.getPredicates();
        model.addAttribute("predicates", list);
    	
    	System.out.println(skiDataForm.getProperty());
    	
    	SkiDataForm.writeHatGewonnen(skiDataForm.getName(), skiDataForm.getWeltCup(), skiDataForm.getProperty());
    	
    	//Update TBS-DB
		//SkiWC_updateTDB.executeUpdate(dataset, queryFile);
        
		return "redirect:/index";
    }
    
    @RequestMapping(value = { "/form" }, method = RequestMethod.GET)
    public String selectProperty(Model model) {
     
        SkiDataForm form = new SkiDataForm();
        model.addAttribute("skiDataForm", form);
     
        List<String> list = PredicateDAO.getPredicates();
        model.addAttribute("predicates", list);
     
        return "form";
    }

    //@GetMapping("/form")
    //public String showForm(SkiDataForm skiDataForm) {
    //    return "form";
    //}
   
}