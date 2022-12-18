package practice.designpatterns.strategy;

public class RubberDuck extends Duck {
    //Should not fly
    @Override
    public void display() {
        System.out.println("Rubber duck");
    }

    @Override
    public void performQuack(){
        System.out.println("Queek, rubber duck");
    }

}
