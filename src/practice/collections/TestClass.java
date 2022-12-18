package practice.collections;

import java.util.Arrays;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,3,2,1,5,3,6,3);
        for(int i:list){
            i++;
            System.out.println(i);
        }
        list.forEach(System.out::println);
    }
}
