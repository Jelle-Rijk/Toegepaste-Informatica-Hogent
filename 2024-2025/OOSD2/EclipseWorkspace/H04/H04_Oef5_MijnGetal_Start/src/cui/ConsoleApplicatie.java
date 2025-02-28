package cui;

import domein.DomeinController;

import java.util.Scanner;

public class ConsoleApplicatie
{
	private DomeinController dc;
	
    public ConsoleApplicatie(DomeinController dc)
    {
    	this.dc = dc;
    }
    
    public void start()
    {
        Scanner s = new Scanner(System.in);
        boolean nogIetsFout = true;

        System.out.print("Geef 2 positieve getallen gescheiden door een spatie: ");
        String invoer = s.nextLine();
        String[] stukjes = null;
    }
}