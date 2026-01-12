import java.util.*;

public class SortMapByKey {
    public static void main(String[] args) {
        
        // HashMap তৈরি করা হয়েছে — এটি কোনো ক্রম বজায় রাখে না (unordered)
        Map<String, Integer> map = new HashMap<>();
        
        // কয়েকটা ফলের নাম (key) এবং তাদের পরিমাণ (value) যোগ করা হলো
        map.put("Banana", 3);
        map.put("Apple", 5);
        map.put("Orange", 2);
        
        // TreeMap তৈরি করা হলো এবং constructor-এ পুরো HashMap পাঠানো হয়েছে
        // TreeMap স্বয়ংক্রিয়ভাবে key-গুলোকে natural order-এ সাজিয়ে রাখে
        // String-এর ক্ষেত্রে natural order মানে alphabetical (A → Z)
        Map<String, Integer> sortedByKey = new TreeMap<>(map);
        
        // TreeMap প্রিন্ট করলে key অনুসারে সাজানো অবস্থায় দেখা যাবে
        // আউটপুট: {Apple=5, Banana=3, Orange=2}
        System.out.println("Sorted by Key: " + sortedByKey);
        
        // মনে রাখবেন:
        // • HashMap → কোনো order নেই, দ্রুত কাজ করে
        // • TreeMap → key অনুসারে সবসময় sorted থাকে (red-black tree ব্যবহার করে)
        // • LinkedHashMap → insertion order বজায় রাখে (যে ক্রমে put করা হয়েছে)
    }
}
