package DSA.Recursion;

public class PSubseq {
    public static void main(String[] args) {
        String s = "abc";
        printSubsequences(s, 0, "");
    }

    private static void printSubsequences(String s, int index, String current) {
        if (index == s.length()) {
            System.out.println(current);
            return;
        }

        // Include the current character
        printSubsequences(s, index + 1, current + s.charAt(index));

        // Exclude the current character
        printSubsequences(s, index + 1, current);
    }
}
