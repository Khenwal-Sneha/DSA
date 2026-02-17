package DSA.Recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 10; // Change this value to compute Fibonacci for different n
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));
    }

    public static int fibonacci(int n) {
        // Base cases
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        // Recursive case
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
