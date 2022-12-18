package practice.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class First {
    interface FunInterface {
        int getValue();
    }
    //Functional interfaces
/*    public static void main(String[] args) {
        FunInterface funInterface;
        funInterface = () -> (int) 5.123;
        System.out.println(funInterface.getValue());
    }*/

// Lambda and method reference
/*public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>(Arrays.asList(2,6,44,8,5,5,4,7,4));

    numbers.forEach(value -> System.out.println(value));

//    numbers.forEach(System.out::println);

    numbers.stream().map(String::valueOf).forEach(System.out::println);
    *//*
     Diff from line 23 & 25 is that in line 23 Method reference is used for static method and object is passsed to it
     and in line 25 Method ref is used for instance method, and that method is invoked on object itself
    *//*
    numbers.stream().map(Integer::floatValue).forEach(System.out::println);
}*/

    //Function to get sum of twice of all even numbers in a list
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 6, 44, 8, 5, 5, 4, 7, 4));
        //Imperical way
        int total = 0;
        for (int i :
                numbers) {
            if (i % 2 == 0)
                total += i * 2;
        }
        System.out.println("Total: " + total);

        //Lambda and streams way
        // Function composition
        System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .map(e -> e * 2)
                        .reduce(0, Integer::sum)
        );


        System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .mapToInt(e -> e * 2)
                        .sum()
        );
    }
}
