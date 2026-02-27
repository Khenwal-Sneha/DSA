package DSA.Non_Linear_DSA.Dynamic_Programming.DP_Partition;

import java.util.Arrays;

// User function Template for Java

class Solution {
    int[][] dp;
    public int maxSkill(int[] arr) {
        int[] ar=new int[arr.length+2];
        ar[0]=1;
        for(int i=0;i<arr.length;i++) ar[i+1]=arr[i];
        ar[ar.length-1]=1;
        dp=new int[arr.length+2][arr.length+2];
        for(int[] d:dp) Arrays.fill(d,-1);
        
        return f(1,arr.length,ar);
    }
    
    int f(int i,int j,int[] ar){
        if(i>j) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        int min=0;
        
        for(int k=i;k<=j;k++){
            int res=(ar[i-1]*ar[k]*ar[j+1])+f(i,k-1,ar)+f(k+1,j,ar);
            min=Math.max(min,res);
        }
        
        return dp[i][j]=min;
    }
}

