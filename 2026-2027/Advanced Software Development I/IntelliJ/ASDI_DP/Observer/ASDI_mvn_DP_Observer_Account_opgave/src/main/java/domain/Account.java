package domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Account implements Subject {

    private final List<Observer> observers;

    @Getter
    private double balance;

    @Getter
    private String name;

    public Account(String accountName, double openingDeposit) {
        name = accountName;
        observers = new ArrayList<>();
        setBalance(openingDeposit);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void setBalance(double accountBalance) {
        balance = accountBalance;
        notifyObservers();
    }

    private void notifyObservers() {
        observers.forEach(observer -> observer.update(balance));
    }

    public void withdraw(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException(
                    "Cannot withdraw negative amount");
        }
        setBalance(getBalance() - amount);
    }

    public void deposit(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot deposit negative amount");
        }
        setBalance(getBalance() + amount);
    }

}
