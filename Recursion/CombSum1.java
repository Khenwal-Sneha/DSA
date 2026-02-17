package DSA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombSum1 {

    // Recursive function
    private void findCombinations(int[] arr, int target, int index,
                                  List<Integer> current,
                                  List<List<Integer>> result) {

        // If target becomes 0 → valid combination found
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // If index reaches end OR target becomes negative → stop
        if (index == arr.length || target < 0) {
            return;
        }

        // ✅ Pick the element (stay at same index because unlimited usage allowed)
        if (arr[index] <= target) {
            current.add(arr[index]);
            findCombinations(arr, target - arr[index], index, current, result);
            current.remove(current.size() - 1); // backtrack
        }

        // ❌ Not pick the element (move to next index)
        findCombinations(arr, target, index + 1, current, result);
    }

    // Main function
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    // Driver Code
    public static void main(String[] args) {
        CombSum1 obj = new CombSum1();

        int[] arr = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> answer = obj.combinationSum(arr, target);
        System.out.println(answer);
    }
}
