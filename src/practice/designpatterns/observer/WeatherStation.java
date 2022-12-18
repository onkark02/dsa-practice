package practice.designpatterns.observer;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(5,6,8);
        weatherData.setMeasurements(51,3,3);
        weatherData.setMeasurements(1,3,4);
    }
}
