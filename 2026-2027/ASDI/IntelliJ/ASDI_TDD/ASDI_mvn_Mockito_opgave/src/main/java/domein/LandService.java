package domein;

import lombok.AllArgsConstructor;
import persistentie.PersistentieController;

//STAP 3
@AllArgsConstructor
public class LandService {

    //STAP 1
    private PersistentieController persistentieController;

	//STAP 2
    public LandService() {
        this(new PersistentieController());
    }

    /*STAP 3
    public LandService(PersistentieController persistentieController) {
        this.persistentieController = persistentieController;
    }*/

    public LandStatistiek geefLandStatistiek(String code) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("code mag niet leeg zijn");
        }
        //STAP 4
        //PersistentieController persistentieController = new PersistentieController();
        Land land = persistentieController.findLand(code);
        if (land == null) {
            return null;
        }

        int oppervlakteAlleLanden = persistentieController.findOppervlakteAlleLanden();
        double verhouding = (double) (land.oppervlakte())
                / oppervlakteAlleLanden;
        return new LandStatistiek(code, verhouding);
    }
}