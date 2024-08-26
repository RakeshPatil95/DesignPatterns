package producer;

import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    private List<Observer> observerList;
    private float temperature;
    private float humidity;
    private float pressure;

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public WeatherData() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void registerObservar(Observer observer) {
        observerList.add(observer);

    }

    @Override
    public void deleteObservar(Observer observer) {
        observerList.remove(observer);

    }

    @Override
    public void notifyObservers() {
        for (Observer o : observerList) {
            o.update();
        }


    }

    public void setMeasurments(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    private void measurementsChanged() {
        notifyObservers();
    }
}
