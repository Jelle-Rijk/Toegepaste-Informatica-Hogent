package domein;

import persistentie.PersistentieController;

import java.io.File;
import java.util.List;

public class DomeinController {
    
    private PersistentieController pc = new PersistentieController();
    
    public void persisteerBierGegevensAlsObject(String tekstFileNaam, String objectFileNaam){
        List<Bier> listBier = pc.leesBieren(new File(tekstFileNaam));
        MyListIterable<Bier> bieren = new MyListIterable<>();
        listBier.forEach(bieren::insertAtBack);
        pc.persisteerObject(bieren, new File(objectFileNaam));
    }
    
}
