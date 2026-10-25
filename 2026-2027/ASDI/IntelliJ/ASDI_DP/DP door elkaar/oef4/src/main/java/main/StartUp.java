package main;

import domein.Printer;

public class StartUp {

	public void main() {
		Printer printer = new Printer();
        IO.println(printer.print("jaarOverzicht"));
        IO.println(printer.print("bestelling"));
	}

}
