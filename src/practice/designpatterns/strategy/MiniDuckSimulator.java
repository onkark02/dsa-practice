package practice.designpatterns.strategy;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performQuack();
        System.out.println("Cutting its wings");
        mallardDuck.setFlyBehaviour(new NoFly());
        mallardDuck.performFly();
        System.out.println("Shutting its mouth");
        mallardDuck.setQuackBehaviour(new MuteQuack());
        mallardDuck.performQuack();
    }
}
