package practice.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamsExamples {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 6, 44, 8, 5, 5, 4, 7, 4));
//        long startTime = System.currentTimeMillis();

        // Time taken: 3062
/*        System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .mapToInt(StreamsExamples::heavyCompute)
                        .sum()
        );
        */


        //Time taken: 593
/*        System.out.println(
                numbers.parallelStream()
                        .filter(e -> e % 2 == 0)
                        .mapToInt(StreamsExamples::heavyCompute)
                        .sum()
        );*/
//        long endTime = System.currentTimeMillis();
//        System.out.println("Time taken: "+ (endTime-startTime));



    }

    private static int heavyCompute(int value){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value * 2;
    }
}
