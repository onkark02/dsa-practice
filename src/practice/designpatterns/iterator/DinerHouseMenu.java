package practice.designpatterns.iterator;

public class DinerHouseMenu {
    MenuItem[] menuItems;
    int MAX_ITEMS = 6;
    int pos;

    public DinerHouseMenu(){
        menuItems = new MenuItem[MAX_ITEMS];
        pos = 0;
        addItem("K&B’s Pancake Breakfast",
                "Pancakes with scrambled eggs, and toast",
                true,
                2.99);
        addItem("Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false,
                2.99);
        addItem("Blueberry Pancakes",
                "Pancakes made with fresh blueberries",
                true,
                3.49);
        addItem("Waffles",
                "Waffles, with your choice of blueberries or strawberries",
                true,
                3.59);
    }
    public void addItem(String name, String description, boolean vegetarian, double price ){
        if(pos <= MAX_ITEMS)
            menuItems[pos++]= new MenuItem(name, description, vegetarian, price);
        else
            System.out.println("Menu full");
    }

    public Iterator createIterator(){
        return new DinerMenuIterator(menuItems);
    }
}
