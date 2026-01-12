import java.util.*;

public class SortMapByValue {
    public static void main(String[] args) {
        
        // HashMap তৈরি করা হয়েছে — key হিসেবে ফলের নাম, value হিসেবে পরিমাণ
        Map<String, Integer> map = new HashMap<>();
        
        // কয়েকটা এন্ট্রি যোগ করা হলো
        map.put("Banana", 3);
        map.put("Apple", 5);
        map.put("Orange", 2);
        
        // HashMap-কে সরাসরি value অনুসারে sort করা যায় না
        // তাই প্রথমে map-এর সব entry গুলোকে একটা List-এ নিয়ে আসা হয়েছে
        List<Map.Entry<String, Integer>> list = 
                new ArrayList<>(map.entrySet());
        
        // List-কে value অনুসারে sort করা হচ্ছে
        // Map.Entry.comparingByValue() → value ছোট থেকে বড় (ascending) ক্রমে সাজাবে
        list.sort(Map.Entry.comparingByValue());
        
        // sorted ফলাফল সংরক্ষণের জন্য LinkedHashMap ব্যবহার করা হয়েছে
        // LinkedHashMap insertion order বজায় রাখে → যে ক্রমে put করা হবে সেই ক্রমেই থাকবে
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        
        // sorted List থেকে এক এক করে entry নিয়ে নতুন map-এ রাখা হচ্ছে
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        
        // ফাইনাল sorted map প্রিন্ট করা হচ্ছে
        // value অনুসারে ছোট থেকে বড় ক্রমে দেখা যাবে
        // আউটপুট: {Orange=2, Banana=3, Apple=5}
        System.out.println("Sorted by Value: " + sortedMap);
        
        // মনে রাখবেন:
        // • HashMap → কোনো order নেই
        // • TreeMap → key দিয়ে sorted
        // • LinkedHashMap → insertion order বজায় রাখে (এখানে আমরা নিজেরা sorted order-এ put করেছি)
    }
}
