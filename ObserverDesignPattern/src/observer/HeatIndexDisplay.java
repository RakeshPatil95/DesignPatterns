package observer;

import producer.WeatherData;

public class HeatIndexDisplay implements Observer, DisplayElement {
    double heatIndex;
    private final WeatherData weatherData;

    public HeatIndexDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObservar(this);
    }

    public double getHeatIndex() {
        return heatIndex;
    }

    public void setHeatIndex(double heatIndex) {
        this.heatIndex = heatIndex;
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + getHeatIndex());
    }

    @Override
    public void update() {
        setHeatIndex(calculateHeatIndex(weatherData.getTemperature(), weatherData.getHumidity()));
        display();
    }

    private double calculateHeatIndex(double temperature, double humidity) {
        // Coefficients for the formula
        double c1 = -42.379;
        double c2 = 2.04901523;
        double c3 = 10.14333127;
        double c4 = -0.22475541;
        double c5 = -0.00683783;
        double c6 = -0.05481717;
        double c7 = 0.00122874;
        double c8 = 0.00085282;
        double c9 = -0.00000199;

        // Calculate the heat index

        return c1
                + (c2 * temperature)
                + (c3 * humidity)
                + (c4 * temperature * humidity)
                + (c5 * Math.pow(temperature, 2))
                + (c6 * Math.pow(humidity, 2))
                + (c7 * Math.pow(temperature, 2) * humidity)
                + (c8 * temperature * Math.pow(humidity, 2))
                + (c9 * Math.pow(temperature, 2) * Math.pow(humidity, 2));
    }
}
