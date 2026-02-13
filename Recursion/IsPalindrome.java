package DSA.Recursion;

import java.util.Scanner;

public class IsPalindrome {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String str = sc.nextLine();
            System.out.println(isPalindrome(str));
        }
    }

    static boolean isPalindrome(String str) {
        // code here
        return f(0, str);
    }

    static boolean f(int i, String str) {
        if (i >= str.length() / 2) return true;

        if (str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;

        return f(i + 1, str);
    }
}
