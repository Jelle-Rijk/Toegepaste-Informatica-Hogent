package domein_oef1;

public class WeerStationController {

    private WeerStation weerStation;

    public double getTemperature() {
        return weerStation.getTemperature();
    }
    //...
}

class WeerStation {

    private Thermometer thermometer;

    public Thermometer getThermometer() {
        return thermometer;
    }

    public double getTemperature() {
        return thermometer.getTemperature();
    }
    //...
}

class Thermometer {

    private double temperature;

    public double getTemperature() {
        return temperature;
    }
    //...
}