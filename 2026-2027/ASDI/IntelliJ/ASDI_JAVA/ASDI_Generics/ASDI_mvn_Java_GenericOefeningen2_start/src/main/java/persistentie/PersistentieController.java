package persistentie;

import domein.Bier;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.List;

public class PersistentieController {

   private BierMapper bierMapper;

    public List<Bier> leesBieren(File besnaam) {
        if (bierMapper == null) {
            bierMapper = new BierMapper();
        }
        return bierMapper.leesBieren(besnaam);
    }
     
    public void persisteerObject(Object object, File besnaam) {
    	besnaam = new File("target/" + besnaam);
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(besnaam.toPath()))) {
            out.writeObject(object);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
