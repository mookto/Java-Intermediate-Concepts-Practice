import java.util.*;

public class SortListExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 3);

        // Ascending sort
        Collections.sort(numbers);
        System.out.println("Ascending: " + numbers);

        // Descending sort
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Descending: " + numbers);
    }
}
