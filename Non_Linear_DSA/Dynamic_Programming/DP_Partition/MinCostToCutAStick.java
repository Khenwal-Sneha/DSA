package DSA.Non_Linear_DSA.Dynamic_Programming.DP_Partition;

import java.util.Arrays;

class Solution {
    int[][] dp;
    public int minCutCost(int n, int[] arr) {
        int[] cuts=new int[arr.length+2];
        for(int i=0;i<arr.length;i++){
            cuts[i]=arr[i];
        }
        cuts[arr.length]=0;
        cuts[arr.length+1]=n;
        Arrays.sort(cuts);
        dp=new int[cuts.length][cuts.length];
        for(int[] d:dp) Arrays.fill(d,-1);
        
        return f(0,cuts.length-1,cuts);
    }
    
    int f(int i,int j,int[] cuts){
        if(j-i<=1) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int min=100000;
        
        for(int k=i+1;k<j;k++){
            int res=cuts[j]-cuts[i]+f(i,k,cuts)+f(k,j,cuts);
            min=Math.min(min,res);
        }
        
        return dp[i][j]=min;
    }
}

