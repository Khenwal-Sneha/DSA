
class Solution {
    int[][] dp;
    public int maxProfit(int arr[], int k) {
        dp=new int[arr.length][2];
        for(int[] d:dp) Arrays.fill(d,-1);
        
        return f(0,0,arr,k);
    }
    
    int f(int i,int h,int[] arr,int k){
        if(i>=arr.length) return 0;
        
        if(dp[i][h]!=-1) return dp[i][h];
        int max=0;
        
        if(h==0){
            max=Math.max(max,-arr[i]+f(i+1,1,arr,k));
            max=Math.max(max,f(i+1,0,arr,k));
        }else{
            max=Math.max(max,arr[i]-k+f(i+1,0,arr,k));
            max=Math.max(max,f(i+1,1,arr,k));
        }
        
        return dp[i][h]=max;
    }
}