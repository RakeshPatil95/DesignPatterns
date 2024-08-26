package producer;

import observer.Observer;

public interface Subject {
    public void registerObservar(Observer observer);
    public void deleteObservar(Observer observer);
    public void notifyObservers();
}
