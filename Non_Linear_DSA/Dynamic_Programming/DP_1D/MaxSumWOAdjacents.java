package DSA.Non_Linear_DSA.Dynamic_Programming.DP_1D;

import java.util.Arrays;

public class MaxSumWOAdjacents {
    int[] dp;
    int findMaxSum(int arr[]) {
        dp=new int[arr.length];
        Arrays.fill(dp,-1);
        return f(0,arr);
    }
    
    int f(int i,int[] arr){
        if(i>=arr.length) return 0;
        if(i==arr.length) return arr[i];
        
        if(dp[i]!=-1) return dp[i];
        int take=arr[i]+f(i+2,arr);
        int notTake=f(i+1,arr);
        
        return dp[i]=Math.max(take,notTake);
    }
}

// Tabulation with optimised space
class Solution {
    int findMaxSum(int arr[]) {
        int n=arr.length;
        int prev=arr[n-1];
        int sec=0;
        
        for(int i=n-2;i>=0;i--){
            int take=arr[i]+sec;
            int notTake=prev;
            
            sec=prev;
            prev=Math.max(take,notTake);
        }
        
        return prev;
    }
}
