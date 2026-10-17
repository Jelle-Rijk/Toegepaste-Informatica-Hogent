package domein;

import java.beans.PropertyChangeListener;

public class DomeinController {

    private ObservableInteger observableInteger = new ObservableInteger();

    public void up() {
        observableInteger.add(1);
    }

    public void down() {
        observableInteger.subtract(1);
    }

    public int getDoubleValue() {
        return observableInteger.getDoubleValue();
    }

    public void addObserver(PropertyChangeListener listener) {
        observableInteger.addObserver(listener);
    }

    public void removeObserver(PropertyChangeListener listener) {
        observableInteger.removeObserver(listener);
    }
}
