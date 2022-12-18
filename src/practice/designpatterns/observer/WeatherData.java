package practice.designpatterns.observer;

import java.util.Observable;

public class WeatherData extends Observable {

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    private float temperature, humidity, pressure;

    public void measurementsChanged(){
        setChanged();
        notifyObservers(); //NOt sendning parameters indicater that we are using pull mode
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
