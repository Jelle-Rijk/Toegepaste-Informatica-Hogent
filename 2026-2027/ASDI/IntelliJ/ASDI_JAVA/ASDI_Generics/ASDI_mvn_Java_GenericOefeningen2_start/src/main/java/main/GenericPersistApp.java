package main;

import domein.DomeinController;

public class GenericPersistApp {

    public void main() {
        new DomeinController().persisteerBierGegevensAlsObject("bieren.txt","bierenListObj.dat");
    }

}

