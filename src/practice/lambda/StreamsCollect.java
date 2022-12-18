package practice.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsCollect {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 6, 44, 8, 5, 5, 4, 7, 4));

        //Double the even values and put into list

        //Wrong way
        List<Integer> doubleOfEven = new ArrayList<>();
        numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .forEach(e -> doubleOfEven.add(e)); //don't do this // shared mutability

        //USing collectors
        List<Integer> doubleOfEven2 = numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .collect(Collectors.toList());

        //groupingBy, mapping
    }
}
