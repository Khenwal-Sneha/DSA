import java.util.Arrays;

class Solution {
    int[][] dp;
    public int maxProfit(int arr[]) {
        dp=new int[arr.length][2];
        for(int[] d:dp) Arrays.fill(d,-1);
        
        return f(0,0,arr);
    }
    
    int f(int i,int have,int[] arr){
        if(i>=arr.length) return 0;
        
        if(dp[i][have]!=-1) return dp[i][have];
        
        int max=0;
        if(have==0){
            max=Math.max(max,-arr[i]+f(i+1,1,arr));
            max=Math.max(max,f(i+1,0,arr));
        }else{
            max=Math.max(max,arr[i]+f(i+2,0,arr));
            max=Math.max(max,f(i+1,1,arr));
        }
        
        return dp[i][have]=max;
    }
}
