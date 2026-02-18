class Solution {
    static int[][] dp;
    static int s;
    static int findTargetSumWays(int N, int[] A, int target) {
        s=0;
        for(int a:A) s+=a;
        dp=new int[A.length][2*s+1];
        for(int[] d:dp) Arrays.fill(d,-1);
        return f(0,A,0,target);
    }
    
    
    static int f(int i,int[] a,int sum,int t){
        if(i==a.length){
            if(sum==t) return 1;
            return 0;
        }
        
        if(dp[i][sum+s]!=-1) return dp[i][sum+s];
        
        int ans=f(i+1,a,sum-a[i],t);
        ans+=f(i+1,a,sum+a[i],t);
        
        return dp[i][sum+s]=ans;
    }
}
        