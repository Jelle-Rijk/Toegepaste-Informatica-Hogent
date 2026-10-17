package domein;

import lombok.Getter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ObservableInteger {
    private PropertyChangeSupport subject = new PropertyChangeSupport(this);
	
    @Getter private int value = 1;
    
    public void setValue(int value) {
        int oldValue = this.value;
    	this.value = value;
        subject.firePropertyChange("integer", oldValue, value);
    }

    public void addObserver(PropertyChangeListener listener) {
        subject.addPropertyChangeListener(listener);
    }

    public void removeObserver(PropertyChangeListener listener) {
        subject.removePropertyChangeListener(listener);
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
