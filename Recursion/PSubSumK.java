package DSA.Recursion;

public class PSubSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int k = 3;
        System.out.println(countSubsequencesWithSumK(arr, k));
    }

    private static int countSubsequencesWithSumK(int[] arr, int k) {
        return countSubsequences(arr, 0, 0, k);
    }

    private static int countSubsequences(int[] arr, int index, int currentSum, int k) {
        if (index == arr.length) {
            return currentSum == k ? 1 : 0;
        }

        // Include the current element
        int include = countSubsequences(arr, index + 1, currentSum + arr[index], k);

        // Exclude the current element
        int exclude = countSubsequences(arr, index + 1, currentSum, k);

        return include + exclude;
    }
}
