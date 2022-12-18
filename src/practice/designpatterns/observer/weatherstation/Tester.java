package practice.designpatterns.observer.weatherstation;

public class Tester {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherStation);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherStation);
        weatherStation.setMeasurements(5,10,15);
        weatherStation.setMeasurements(10,5,20);
    }
}
