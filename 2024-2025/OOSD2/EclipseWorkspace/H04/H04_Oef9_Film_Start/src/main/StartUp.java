
package main;

import domein.DomeinController;
import ui.VertoonbaarApplicatie;

public class StartUp {
    public static void main(String[] args) {
        
    	try {
    	DomeinController dc = new DomeinController();
    	VertoonbaarApplicatie app = new VertoonbaarApplicatie(dc);
    	app.start(); }
    	catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
}
