package practice.designpatterns.iterator;

public class Tester {
    public static void main(String[] args) {
        Waitress waitress = new Waitress(new DinerHouseMenu() ,new PancakeHouseMenu());
        waitress.printMenu();
    }
}
