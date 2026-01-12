import java.util.*;
import java.util.stream.*;

public class StreamPractice {
    public static void main(String[] args) {
        
        // ধাপ ১: একটা List তৈরি করা হয়েছে (Arrays.asList দিয়ে সহজে)
        // এই লিস্টে কিছু র‍্যান্ডম সংখ্যা রাখা হয়েছে
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 4, 7, 6);
        
        // ধাপ ২: Stream API ব্যবহার করে এক লাইনে অনেক কাজ করা হচ্ছে
        // এটাই Stream-এর সবচেয়ে বড় সুবিধা — চেইন করে অপারেশন করা যায়
        List<Integer> result = numbers.stream()                  // List থেকে Stream তৈরি
        
                // ফিল্টার: শুধু জোড় (even) সংখ্যা রাখবে
                // n % 2 == 0 → জোড় সংখ্যা চেক করে
                .filter(n -> n % 2 == 0)                         
                
                // সাজানো: বড় থেকে ছোট (descending) ক্রমে
                // Comparator.reverseOrder() → উল্টো ক্রমে সাজায়
                .sorted(Comparator.reverseOrder())                
                
                // ম্যাপ: প্রতিটি সংখ্যাকে তার বর্গ (square) করে
                // n → n * n
                .map(n -> n * n)                                  
                
                // শেষে Stream কে আবার List-এ রূপান্তর করা
                // Collectors.toList() → সব ফলাফল List-এ জমা করে
                .collect(Collectors.toList());                    
        
        // ধাপ ৩: ফাইনাল ফলাফল প্রিন্ট করা
        // আউটপুট হবে: [64, 36, 16, 4] 
        // ব্যাখ্যা: 8→64, 6→36, 4→16, 2→4   (জোড় সংখ্যাগুলোর বর্গ, বড় থেকে ছোট)
        System.out.println(result);
        
        // মনে রাখবেন:
        // • stream() → intermediate operations (filter, sorted, map) লেজি — আসল কাজ collect() এর সময় হয়
        // • collect(Collectors.toList()) → terminal operation — এটাই Stream কে শেষ করে
        // • প্রতিটি অপারেশন নতুন Stream রিটার্ন করে → chaining সম্ভব
    }
}
