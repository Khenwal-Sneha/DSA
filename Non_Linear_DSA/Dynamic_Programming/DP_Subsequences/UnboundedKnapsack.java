// User function Template for Java

class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        int[][] dp=new int[val.length][capacity+1];
        for(int[] rows:dp) Arrays.fill(rows,-1);
        
        return f(val.length-1,capacity,val,wt,dp);
    }
    
    static int f(int idx,int W,int[] val,int[] wt,int[][] dp){
        if(W==0) return 0;
        if(idx<0) return 0;
        
        if(dp[idx][W]!=-1) return dp[idx][W];
        
        int notPick=f(idx-1,W,val,wt,dp);
        int pick=0;
        if(wt[idx]<=W) pick=val[idx]+f(idx,W-wt[idx],val,wt,dp);
        
        return dp[idx][W]=Math.max(pick,notPick);
    }
}