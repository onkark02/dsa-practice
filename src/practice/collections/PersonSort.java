package practice.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonSort {
    public static void main(String[] args) {
        Comparator<Person> namePriority = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getName().equals(o2.getName())){
                    return o1.getAge() - o2.getAge();
                }else
                    return o1.getName().compareTo(o2.getName());
            }
        };
        Comparator<Person> agePriority = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getAge()  == o2.getAge()){
                    return o1.getName().compareTo(o2.getName());

                }else
                    return o1.getAge() - o2.getAge();
            }
        };
        List<Person> list = createPersons();
        System.out.println(list);
        Collections.sort(list,namePriority);
        System.out.println("Namewise: "+list);
        Collections.sort(list,agePriority);
        System.out.println("Agewise: "+list);
    }

    static List<Person> createPersons(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("aba",10));
        list.add(new Person("baba",10));
        list.add(new Person("sam",10));
        list.add(new Person("baba",20));
        list.add(new Person("baba",50));
        return list;
    }

}
