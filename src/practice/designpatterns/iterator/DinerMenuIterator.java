package practice.designpatterns.iterator;

public class DinerMenuIterator implements Iterator {
    MenuItem[] menuItems;
    int pos;

    public DinerMenuIterator(MenuItem[] menuItems){
        this.menuItems = menuItems;
        this.pos = 0;
    }

    @Override
    public boolean hasNext() {
        return pos <= menuItems.length && menuItems[pos] != null;
    }

    @Override
    public Object next() {
        return this.menuItems[pos++];
    }
}
