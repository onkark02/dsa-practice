package practice.designpatterns.strategy;

public abstract class Duck {
    FlyBehaviour flyBehaviour;
    QuackBehaviour quackBehaviour;

    public void performQuack() {
        quackBehaviour.quack();
    }

    public void swim() {
        System.out.println("Swimming");
    }

    public abstract void display();

    public void performFly() {
        flyBehaviour.fly();
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour){
        this.flyBehaviour = flyBehaviour;
    }
    public void setQuackBehaviour(QuackBehaviour quackBehaviour){
        this.quackBehaviour = quackBehaviour;
    }
}
