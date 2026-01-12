import java.util.*;

public class SortListExample {
    public static void main(String[] args) {
        
        // একটা List তৈরি করা হলো (অপরিবর্তনীয় List, কিন্তু sort করা যাবে)
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 3);
        
        // Ascending (ছোট থেকে বড়) ক্রমে সাজানো
        // Collections.sort() ডিফল্টভাবে natural ordering ব্যবহার করে (অর্থাৎ ascending)
        Collections.sort(numbers);
        
        // সাজানোর পর লিস্টের বর্তমান অবস্থা প্রিন্ট
        System.out.println("Ascending: " + numbers);
        
        // Descending (বড় থেকে ছোট) ক্রমে সাজানো
        // Collections.reverseOrder() একটা Comparator রিটার্ন করে যা উল্টো ক্রমে তুলনা করে
        Collections.sort(numbers, Collections.reverseOrder());
        
        // আবার সাজানোর পর লিস্ট প্রিন্ট
        System.out.println("Descending: " + numbers);
    }
}
