package practice.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModificationException {
    public static void main(String[] args) {


        List<String> list = new ArrayList<>(Arrays.asList("small","Big"));

        System.out.println(list);
        list.removeIf(value -> Character.isLowerCase(value.charAt(0)));
        System.out.println(list);

    }
}
