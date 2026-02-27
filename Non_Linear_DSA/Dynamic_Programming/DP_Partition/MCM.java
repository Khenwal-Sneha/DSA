package DSA.Non_Linear_DSA.Dynamic_Programming.DP_Partition;

import java.util.Arrays;

class Solution {
    static int[][] dp;
    static int matrixMultiplication(int arr[]) {
        dp=new int[arr.length-1][arr.length-1];
        for(int[] d:dp) Arrays.fill(d,-1);
        return f(0,arr.length-2,arr);
    }
    
    static int f(int i,int j,int[] arr){
        if(i==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int res=arr[i]*arr[k+1]*arr[j+1]+f(i,k,arr)+f(k+1,j,arr);
            min=Math.min(min,res);
        }
        
        return dp[i][j]=min;
    }
}
