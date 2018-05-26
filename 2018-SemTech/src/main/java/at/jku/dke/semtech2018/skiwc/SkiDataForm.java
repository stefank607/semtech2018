package at.jku.dke.semtech2018.skiwc;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class SkiDataForm {

    @NotNull
    @Size(min=2, max=30)
    private String name;
    private String weltCup;
    private int jahr;
    private List<String> relation;
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getWeltCup() {
		return weltCup;
	}

	public void setWeltCup(String weltCup) {
		this.weltCup = weltCup;
	}

	public static void writeHatGewonnen(String name, String weltCup) throws IOException {
		PrintStream stdout = System.out;
		System.setOut(new PrintStream(new File("C:/dev/git/2018-SemTech/src/main/resources/at/jku/dke/semtech2018/skiwc/updatesTDB/update2.ru")));

		

		BufferedReader reader = new BufferedReader(new FileReader("C:/dev/git/2018-SemTech/src/main/resources/at/jku/dke/semtech2018/skiwc/updatesTDB/update2.ru"));

		String line = 	":" + name + " :hatGewonnen : " + weltCup;
	    System.out.println(line);
		
		/*
		while((line = reader.readLine()) != null){
		    System.out.println(line);
		}*/
		reader.close();
	}
}