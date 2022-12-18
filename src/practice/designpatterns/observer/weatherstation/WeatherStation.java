package practice.designpatterns.observer.weatherstation;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{
    private List<Observer> observers;

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    private float temperature;
    private float pressure;
    private float humidity;

    public WeatherStation(){
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o: observers)
            o.update();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public void measurementsChanged() {
        notifyObservers();
    }
}
