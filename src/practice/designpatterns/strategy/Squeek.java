package practice.designpatterns.strategy;

public class Squeek implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Squeek");
    }
}
