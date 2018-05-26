package at.jku.dke.semtech2018.skiwc;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
		
		//TBD Generisch sämtliche Relations ausgeben
		String line = 	"INSERT DATA { \n" + ":" + name + " :hatGewonnen : " + weltCup + "\n}";
    	//System.out.println(":" + name + " :hatGewonnen : " + weltCup);
    	
        File file = new File("C:/dev/git/2018-SemTech/src/main/resources/at/jku/dke/semtech2018/skiwc/updatesTDB/update2.ru");
        file.createNewFile();
        FileWriter writer = new FileWriter(file); 
        writer.write(line); 
        writer.flush();
        writer.close();
	}
}