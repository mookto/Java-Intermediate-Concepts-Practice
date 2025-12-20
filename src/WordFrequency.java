import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "java is easy and java is powerful";

        String[] words = text.split(" ");
        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        System.out.println(freqMap);
    }
}
