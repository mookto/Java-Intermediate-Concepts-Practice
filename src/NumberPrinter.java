class NumberPrinter {

    private int number = 1;
    private final int MAX = 10;

    // Print odd numbers
    public synchronized void printOdd() {
        while (number <= MAX) {
            while (number % 2 == 0) {
                try {
                    wait(); // wait if number is even
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number <= MAX) {
                System.out.println("Odd  : " + number);
                number++;
                notify(); // wake up even thread
            }
        }
    }

    // Print even numbers
    public synchronized void printEven() {
        while (number <= MAX) {
            while (number % 2 == 1) {
                try {
                    wait(); // wait if number is odd
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number <= MAX) {
                System.out.println("Even : " + number);
                number++;
                notify(); // wake up odd thread
            }
        }
    }
}



