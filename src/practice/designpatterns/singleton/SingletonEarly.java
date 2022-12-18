package practice.designpatterns.singleton;

public class SingletonEarly {
    private static SingletonEarly instance = new SingletonEarly();

    public static SingletonEarly getInstance(){
        return instance;
    }
}
