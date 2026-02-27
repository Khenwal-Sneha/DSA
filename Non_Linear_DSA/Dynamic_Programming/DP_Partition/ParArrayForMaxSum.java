package DSA.Non_Linear_DSA.Dynamic_Programming.DP_Partition;

import java.util.Arrays;

class Solution {
    int[] dp;
    int tar;
    public int solve(int N, int k, int arr[]) {
        dp=new int[arr.length];
        tar=k;
        Arrays.fill(dp,-1);
        
        return f(0,k,arr);
    }
    
    int f(int i,int k,int[] arr){
        if(i>=arr.length) return 0;
        
        if(dp[i]!=-1) return dp[i];
        int max=0;
        int currMax=0;
        
        int j=1;
        while(i+j-1<arr.length && j<=k){
            currMax=Math.max(currMax,arr[i+j-1]);
            max=Math.max(max,(j*currMax)+f(i+j,k,arr));
            j++;
        }
        
        return dp[i]=max;
    }
}
