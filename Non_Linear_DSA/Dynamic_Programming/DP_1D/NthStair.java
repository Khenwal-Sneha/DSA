package DSA.Non_Linear_DSA.Dynamic_Programming.DP_1D;
// There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Your task is to count the number of ways, the person can reach the top (order does matter).
// Input: n = 4
// Output: 5
// Explanation: There are five ways to reach 4th stair: {1, 1, 1, 1}, {1, 1, 2}, {2, 1, 1}, {1, 2, 1} and {2, 2}.

import java.util.Arrays;

public class NthStair {
    int[] dp;
    int countWays(int n) {
        dp=new int[n];
        Arrays.fill(dp,-1);
        return f(0,n);
    }
    
    int f(int curr,int n){
        if(curr==n) return 1;
        if(curr>n) return 0;
        
        if(dp[curr]!=-1) return dp[curr];
        
        //Take 1 step
        int step1=f(curr+1,n);
        
        //Take 2 step
        int step2=f(curr+2,n);
        
        return dp[curr]=step1+step2;
    }
}

//Tabulation with optimised space
class Solution {
    int countWays(int n) {
        int prev=1;
        int sec=0;
        for(int i=n-1;i>=0;i--){
            int step1=prev;
            int step2=sec;
            sec=prev;
            prev=step1+step2;
        }
        return prev;
    }
}

