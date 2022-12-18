package threads.producerconsumer;

public class Item {
    private int value;

    public Item(){
        this.value = (int) (Math.random()*100);
        System.out.println("Created item with value: "+ value);
    }

    public void process(){
        System.out.println("Processed item with value: "+ value);
    }
}
