package main;

import domein.DomeinController;
import ui.StripfigurenApp;

public class StartUp 
{
	public static void main(String[] args) 
	{
		new StripfigurenApp(new DomeinController()).start();
	}

	
}
