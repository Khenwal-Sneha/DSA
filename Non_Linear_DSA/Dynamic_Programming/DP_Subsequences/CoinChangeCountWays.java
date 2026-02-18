class Solution {
    int[][] dp;
    public int count(int coins[], int sum) {
       dp=new int[coins.length][sum+1];
       for(int[] d:dp) Arrays.fill(d,-1);
       
       return f(0,coins,sum);
    }
    
    int f(int i,int[] coins,int sum){
        if(sum<0) return 0;
        if(i>=coins.length){
            if(sum==0) return 1;
            return 0;
        }
        
        if(dp[i][sum]!=-1) return dp[i][sum];
        
        int ans=f(i,coins,sum-coins[i]);
        ans+=f(i+1,coins,sum);
        
        return dp[i][sum]=ans;
    }
}