package DSA.Non_Linear_DSA.Dynamic_Programming.DP_1D;

import java.util.Arrays;

public class HouseRobber1 {
    int[] dp;

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return f(0, nums);
    }

    int f(int i, int[] nums) {
        if (i >= nums.length)
            return 0;
        if (i == nums.length)
            return nums[i];

        if (dp[i] != -1)
            return dp[i];
        int take = nums[i] + f(i + 2, nums);
        int notTake = f(i + 1, nums);

        return dp[i] = Math.max(take, notTake);
    }
}

// Tabulation with optimised space
class Solution {
    public int rob(int[] nums) {
        int prev=nums[nums.length-1];
        int sec=0;
        for(int i=nums.length-2;i>=0;i--){
            int take=nums[i]+sec;
            int notTake=prev;

            sec=prev;
            prev=Math.max(take,notTake);
        }
        return prev;
    }
}
