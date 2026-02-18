class Solution {
    
    int[][] dp;
    public int countPartitions(int[] arr, int diff) {
        int sum=0;
        for(int a:arr) sum+=a;
        if(sum<diff) return 0;
        int tar=sum+diff;
        if(tar%2!=0) return 0;
        dp=new int[arr.length][tar/2 +1];
        for(int[] d:dp) Arrays.fill(d,-1);
        
        return f(0,arr,tar/2);
    }
    
    int f(int i,int[] arr,int sum){
        if(sum<0) return 0;
        if(i>=arr.length){
            if(sum==0) return 1;
            return 0;
        }
        
        if(dp[i][sum]!=-1) return dp[i][sum];
        
        int ans1=f(i+1,arr,sum-arr[i]);
        int ans2=f(i+1,arr,sum);
        
        return dp[i][sum]=ans1+ans2;
    }
}
