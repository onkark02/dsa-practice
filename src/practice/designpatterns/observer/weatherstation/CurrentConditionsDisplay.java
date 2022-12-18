package practice.designpatterns.observer.weatherstation;

public class CurrentConditionsDisplay implements DisplayElement, Observer{
    private float temperature;
    private float pressure;
    private float humidity;
    private WeatherStation weatherStation;

    public CurrentConditionsDisplay(WeatherStation weatherStation){
        this.weatherStation = weatherStation;
        this.weatherStation.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.printf("Temperature: %f, Pressure: %f, Humidity: %f\n",this.temperature,this.pressure,this.humidity);
    }

    @Override
    public void update() {
        this.temperature = weatherStation.getTemperature();
        this.pressure = weatherStation.getPressure();
        this.humidity = weatherStation.getHumidity();
        display();
    }
}
