package main;

// Op het einde van de oefening: vervang domeinSlecht.DocumentManager
// door domein.DocumentManager.
import domeinSlecht.DocumentManager;
// import domein.DocumentManager;

public class StartUp {

    public void main() {
        DocumentManager manager = new DocumentManager();
        manager.print("document.xlsx");
        manager.print("document.bestaatNiet");
    }

}
