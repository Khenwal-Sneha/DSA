package DSA.Non_Linear_DSA.Dynamic_Programming.DP_1D;

import java.util.Arrays;

public class FrogJump {
    int[] dp;
    int minCost(int[] height) {
        // code here
        dp=new int[height.length];
        Arrays.fill(dp,-1);
        
        return f(0,height);
    }
    
    int f(int i,int[] height){
        if(i>=height.length) return 1000000;
        if(i==height.length-1) return 0;
        
        if(dp[i]!=-1) return dp[i];
        int step1=1000000;
        int step2=1000000;
        
        if(i+1<height.length) step1=Math.min(step1,Math.abs(height[i]-height[i+1]))+f(i+1,height);
        if(i+2<height.length) step2=Math.min(step2,Math.abs(height[i]-height[i+2]))+f(i+2,height);
        
        return dp[i]=Math.min(step1,step2);
    }
}

//Tabulation with optimised space
class Solution {
    int minCost(int[] height) {
        int prev=0;
        int secprev=1000000;
        int n=height.length;
        
        for(int i=height.length-2;i>=0;i--){
            int step1=1000000;
            int step2=1000000;
            if(i+1<n) step1=Math.min(step1,Math.abs(height[i]-height[i+1]))+prev;
            if(i+2<n) step2=Math.min(step2,Math.abs(height[i]-height[i+2]))+secprev;
            
            secprev=prev;
            prev=Math.min(step1,step2);
        }
        
        return prev;
    }
}
