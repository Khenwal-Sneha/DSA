class Solution {
    static Boolean dp[][];
    static Boolean isSubsetSum(int arr[], int sum) {
        dp=new Boolean[arr.length][sum+1];
        return f(0,arr,sum);
    }
    
    static Boolean f(int i,int[] arr,int sum){
        if(sum<0) return false;
        if(sum==0) return true;
        if(i>=arr.length) return false;
        if(dp[i][sum]!=null) return dp[i][sum];
        Boolean ans=false;
        ans=ans || f(i+1,arr,sum-arr[i]);
        ans=ans || f(i+1,arr,sum);
        
        return dp[i][sum]=ans;
    }
}