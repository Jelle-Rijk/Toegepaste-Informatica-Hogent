package main;

import domein.GarageController;

public class MAINapp {
    private GarageController dc;

    public void main() {
        new MAINapp().run();
    }

    public void run() {
        dc = new GarageController();
        IO.println("Garage Applicatie gestart");
        System.out.printf("Auto's met onderhoud : %s%n", dc.geefAutosMetOnderhoudsbeurt());
        System.out.printf("Auto's met zonder onderhoud : %s%n",dc.geefAutosZonderOnderhoudsbeurt());       
        System.out.printf("Onderhoudsbeurten op 2026/6/10 : %s%n",dc.geefOnderhoudsbeurtenOpDatum(2026, 6, 10));
        dc.close();
    }
    
}
