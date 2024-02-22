package Observer;

import java.util.ArrayList;
import java.util.List;

public class MySubject implements Subject{
    private static MySubject instance;
    private final List<Observer> observers = new ArrayList<>();

    private MySubject() {}

    public static synchronized MySubject getInstance() {
        if (instance == null) {
            instance = new MySubject();
        }
        return instance;
    }
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}


