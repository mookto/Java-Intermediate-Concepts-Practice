import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        
        // একটা টেক্সট স্ট্রিং দেওয়া হয়েছে যার মধ্যে শব্দের পুনরাবৃত্তি আছে
        String text = "java is easy and java is powerful";
        
        // টেক্সটকে স্পেস (" ") দিয়ে ভাগ করে শব্দের অ্যারে বানানো হয়েছে
        // ফলে words অ্যারেতে হবে: ["java", "is", "easy", "and", "java", "is", "powerful"]
        String[] words = text.split(" ");
        
        // প্রতিটি শব্দ কতবার এসেছে তা গণনা করার জন্য HashMap ব্যবহার করা হয়েছে
        // Key = শব্দ (String), Value = সেই শব্দ কতবার এসেছে (Integer)
        Map<String, Integer> freqMap = new HashMap<>();
        
        // প্রতিটি শব্দের উপর লুপ চালানো হচ্ছে (enhanced for loop)
        for (String word : words) {
            
            // getOrDefault() → যদি শব্দটি আগে থেকে map-এ না থাকে তাহলে 0 রিটার্ন করে
            // তারপর ১ যোগ করে নতুন/আপডেটেড কাউন্ট রাখা হয়
            // এটাই সবচেয়ে সহজ ও পরিষ্কার উপায় word frequency গণনার জন্য
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            
            // বিকল্প পুরোনো স্টাইল (Java 7 বা তার আগে):
            // if (freqMap.containsKey(word)) {
            //     freqMap.put(word, freqMap.get(word) + 1);
            // } else {
            //     freqMap.put(word, 1);
            // }
        }
        
        // ফাইনাল ফ্রিকোয়েন্সি ম্যাপ প্রিন্ট করা হচ্ছে
        // আউটপুট হবে কিছু এরকম: {java=2, is=2, easy=1, and=1, powerful=1}
        // (ক্রম নিশ্চিত নয় কারণ HashMap unordered)
        System.out.println(freqMap);
        
        // মনে রাখবেন:
        // • এই কোড case-sensitive (Java আর java আলাদা ধরবে)
        // • punctuation (যেমন comma, full stop) থাকলে আলাদা শব্দ হিসেবে গণ্য হবে
        // • শুধুমাত্র স্পেস দিয়ে split করা হয়েছে — একাধিক স্পেস বা ট্যাব থাকলে সমস্যা হতে পারে
    }
}
