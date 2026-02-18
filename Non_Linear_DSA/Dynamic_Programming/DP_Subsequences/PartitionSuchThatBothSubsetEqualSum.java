class Solution {
    static Boolean[][] dp;
    static boolean equalPartition(int arr[]) {
        int sum=0;
        for(int a:arr) sum+=a;
        if(sum%2!=0) return false;
        dp=new Boolean[arr.length][sum/2 + 1];
        
        return f(0,arr,sum/2);
    }
    
    static boolean f(int i,int[] arr,int sum){
        if(sum<0) return false;
        if(sum==0) return true;
        if(i>=arr.length) return false;
        
        if(dp[i][sum]!=null) return dp[i][sum];
        
        boolean ans=false;
        ans=ans || f(i+1,arr,sum-arr[i]);
        ans=ans || f(i+1,arr,sum);
        
        return dp[i][sum]=ans;
    }
}