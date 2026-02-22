class Solution {
    static int[][] dp;
    static int lis(int arr[]) {
        dp=new int[arr.length][arr.length+1];
        for(int[] d:dp) Arrays.fill(d,-1);
        
        return f(0,-1,arr);
    }
    
    static int f(int i,int j,int[] arr){
        if(i>=arr.length) return 0;
        
        if(dp[i][j+1]!=-1) return dp[i][j+1];
        
        int ans=0;
        if(j==-1 || arr[i]>arr[j]) ans=Math.max(ans,1+f(i+1,i,arr));
        ans=Math.max(ans,f(i+1,j,arr));
        
        return dp[i][j+1]=ans;
    }
}