package persistentie;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import domein.Bier;

public class BierMapper {

public List<Bier> leesBieren(File besnaam) {
    	
    	try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(besnaam.getPath());
    	     BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
  		
    		 return reader.lines().map(this::leesBier).collect(Collectors.toList());

    	} catch (IOException e) {
    	    e.printStackTrace();  
    	}
    	
    	return null;
    }
    
    private Bier leesBier(String regel) {
        try (Scanner scanner = new Scanner(regel)) {
        	String bierNaam = scanner.next();
			scanner.next();
			double alcohol = scanner.nextDouble();
			return new Bier(bierNaam, alcohol);
        }
    }
    
}   