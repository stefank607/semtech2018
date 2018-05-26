package at.jku.dke.semtech2018.web.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import at.jku.dke.semtech2018.skiwc.SkiDataForm;


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

		String line = 	"INSERT DATA { \n" + ":" + skiDataForm.getName() + " :hatGewonnen : " + skiDataForm.getWeltCup() + "\n}";
    	System.out.println(":" + skiDataForm.getName() + " :hatGewonnen : " + skiDataForm.getWeltCup());
    	//SkiDataForm.writeHatGewonnen(skiDataForm.getName(), skiDataForm.getWeltCup());
        
        File file = new File("C:/dev/git/2018-SemTech/src/main/resources/at/jku/dke/semtech2018/skiwc/updatesTDB/update2.ru");
        file.createNewFile();
        FileWriter writer = new FileWriter(file); 
        writer.write(line); 
        writer.flush();
        writer.close();
    	
        System.out.println(line);
		return "redirect:/results";        
    } 

    /*
    @PostMapping("/")
    public String checkSkiDataInfo(@Valid SkiDataForm skiDataForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/results";
    } */
}