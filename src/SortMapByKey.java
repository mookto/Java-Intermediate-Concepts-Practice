import java.util.*;

public class SortMapByKey {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Banana", 3);
        map.put("Apple", 5);
        map.put("Orange", 2);

        // TreeMap sorts by key automatically
        Map<String, Integer> sortedByKey = new TreeMap<>(map);
        System.out.println("Sorted by Key: " + sortedByKey);
    }
}
