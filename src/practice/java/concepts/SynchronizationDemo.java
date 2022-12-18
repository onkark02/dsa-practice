package practice.java.concepts;

public class SynchronizationDemo {
    public static void main(String[] args) {
        Display d = new Display();
        Thread mt1 = new Thread(()->d.wish("John"));
        Thread mt2 = new Thread(()->new Display().wish("White walker"));
        mt1.start();
        mt2.start();
    }

}

class Display{
    synchronized public static void wish(String name){
        for(int i=0; i<5; i++){
            System.out.print("Good morning: ");
            try{
                Thread.sleep(200);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            System.out.println(name);
        }
    }
}
