package practice.designpatterns.singleton;

public class SingletonLazy {
    private static SingletonLazy singleton;

    private SingletonLazy(){}

    public static SingletonLazy getSingleton(){
        if(singleton == null){
            synchronized (SingletonLazy.class){
                if(singleton == null){
                    singleton = new SingletonLazy();
                }
            }
        }
        return singleton;
    }
}
