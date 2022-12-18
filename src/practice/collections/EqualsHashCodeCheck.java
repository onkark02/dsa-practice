package practice.collections;

import java.util.HashSet;
import java.util.Set;

public class EqualsHashCodeCheck {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        Person p1 = new Person("Ram", 20);
        Person p2 = new Person("Raj",21);
        Person p3 = new Person("Rahul",22);
        set.add(p1);
        set.add(p2);
        set.add(p3);

        Person missing = new Person("Raj",21);
        System.out.println("Missing person found in set: "+set.contains(missing));
        System.out.println("Missing equals p2: "+p2.equals(missing));
    }
}
