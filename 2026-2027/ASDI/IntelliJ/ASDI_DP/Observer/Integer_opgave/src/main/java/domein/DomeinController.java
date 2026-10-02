package domein;

public class DomeinController {

    private ObservableInteger observableInteger = new ObservableInteger();

    public void addIntegerObserver(Observer observer) {
        observableInteger.addObserver(observer);
    }

    public void removeIntegerObserver(Observer observer) {
        observableInteger.removeObserver(observer);
    }

    public void up() {
        observableInteger.add(1);
    }

    public void down() {
        observableInteger.subtract(1);
    }

    public int getDoubleValue() {
        return observableInteger.getDoubleValue();
    }


}
