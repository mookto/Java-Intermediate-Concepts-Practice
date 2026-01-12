class NumberPrinter {
    
    // শেয়ার্ড ভ্যারিয়েবল — দুই থ্রেডই এটাকে ব্যবহার করবে
    private int number = 1;           // বর্তমান যে সংখ্যাটা প্রিন্ট করা হবে
    
    private final int MAX = 10;       // কত পর্যন্ত প্রিন্ট করবো (১ থেকে ১০)
    
    // এই মেথড শুধু বিজোড় (odd) সংখ্যা প্রিন্ট করার জন্য
    // synchronized → একসময়ে শুধু একটা থ্রেডই এই মেথডে ঢুকতে পারবে
    public synchronized void printOdd() {
        
        // যতক্ষণ না number MAX এর চেয়ে বড় হয়
        while (number <= MAX) {
            
            // যদি বর্তমান number জোড় (even) হয় → তাহলে এই থ্রেড অপেক্ষা করবে
            // অর্থাৎ Odd থ্রেড তখনই কাজ করবে যখন number বিজোড় হবে
            while (number % 2 == 0) {
                try {
                    wait();                     // অন্য থ্রেডকে (even) কাজ করতে দাও
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            // এখানে এসে নিশ্চিত যে number বিজোড় (কারণ while লুপ থেকে বের হয়েছে)
            if (number <= MAX) {
                System.out.println("Odd  : " + number);
                number++;                       // পরের সংখ্যায় যাও (এখন জোড় হবে)
                
                notify();                       // even থ্রেডকে জাগিয়ে দাও
                // notify() → যে থ্রেড wait() করছে তাকে বলে "এখন তোমার পালা"
            }
        }
    }
    
    // এই মেথড শুধু জোড় (even) সংখ্যা প্রিন্ট করার জন্য
    public synchronized void printEven() {
        
        while (number <= MAX) {
            
            // যদি বর্তমান number বিজোড় (odd) হয় → তাহলে even থ্রেড অপেক্ষা করবে
            while (number % 2 == 1) {
                try {
                    wait();                     // odd থ্রেডকে কাজ করতে দাও
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            // এখানে এসে নিশ্চিত যে number জোড়
            if (number <= MAX) {
                System.out.println("Even : " + number);
                number++;                       // পরের সংখ্যায় যাও (এখন বিজোড় হবে)
                
                notify();                       // odd থ্রেডকে জাগিয়ে দাও
            }
        }
    }
}
