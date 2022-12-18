package practice.designpatterns.iterator;

public class Waitress {
    DinerHouseMenu dinerHouseMenu;
    PancakeHouseMenu pancakeHouseMenu;

    public Waitress(DinerHouseMenu dinerHouseMenu, PancakeHouseMenu pancakeHouseMenu){
        this.dinerHouseMenu = dinerHouseMenu;
        this.pancakeHouseMenu = pancakeHouseMenu;
    }

    public void printMenu(){
        System.out.println("---------Breakfast menu --------------");
        printMenu(pancakeHouseMenu.createIterator());
        System.out.println("---------Diner menu ----------------");
        printMenu(dinerHouseMenu.createIterator());
    }
        private void printMenu(Iterator iterator) {
            while (iterator.hasNext()) {
                MenuItem menuItem = (MenuItem)iterator.next();
                System.out.print(menuItem.getName() + " ");
                System.out.print(menuItem.getPrice() + " -- ");
                System.out.println(menuItem.getDescription());
            }
    }
}
