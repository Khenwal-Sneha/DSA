package DSA.Recursion;

import java.util.Scanner;

public class Atoi {
    static int sign = 1;
    static long result = 0;

    public static int AtoI(String s) {
        int i = 0;
        int n = s.length();

        // 1. Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Handle sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-')
                sign = -1;
            i++;
        }

        // 3. Start recursion
        dfs(i, s);

        result = result * sign;

        // 4. Clamp to int range
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;
    }

    private static void dfs(int i, String s) {
        if (i >= s.length())
            return;

        char c = s.charAt(i);

        if (!Character.isDigit(c))
            return;

        result = result * 10 + (c - '0');

        // Early overflow stopping
        if (sign == 1 && result > Integer.MAX_VALUE)
            return;
        if (sign == -1 && -result < Integer.MIN_VALUE)
            return;

        dfs(i + 1, s);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine();
            int ans = AtoI(input);
            System.out.println(ans);
        }
    }
}
