package domein;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ObservableInteger implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    @Getter
    private int value = 1;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
        observer.update(value);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        observers.forEach(observer -> observer.update(value));
    }

    public void setValue(int value) {
        this.value = value;
        notifyObservers();
    }

    public void add(int number) {
        setValue(value + number);
    }

    public void subtract(int number) {
        setValue(value - number);
    }

    public int getDoubleValue() {
        return value * 2;
    }
}
