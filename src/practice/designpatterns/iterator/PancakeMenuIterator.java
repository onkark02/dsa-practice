package practice.designpatterns.iterator;

import java.util.ArrayList;

public class PancakeMenuIterator implements Iterator {
    ArrayList menuItems;
    int pos;
    public PancakeMenuIterator(ArrayList menuItems){
        this.menuItems = menuItems;
        this.pos = 0;
    }

    @Override
    public boolean hasNext() {
        return pos < menuItems.size();
    }

    @Override
    public Object next() {
        return menuItems.get(pos++);
    }
}
