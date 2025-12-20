import java.util.*;
import java.util.stream.*;

public class StreamPractice {
    public static void main(String[] args) {

        // Step 1: Create a list
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 4, 7, 6);

        // Step 2: Use Stream to filter, sort, and map
        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)        // keep even numbers only
                .sorted(Comparator.reverseOrder()) // sort in descending order
                .map(n -> n * n)                // square each number
                .collect(Collectors.toList()); // convert stream back to list

        // Step 3: Print result
        System.out.println(result);
    }
}

