class Solution {
    static int lis(int arr[]) {
        int max=1;
       int[] dp=new int[arr.length];
       Arrays.fill(dp,1);
       
       for(int i=0;i<arr.length;i++){
           for(int j=0;j<i;j++){
               if(arr[i]>arr[j]) dp[i]=Math.max(dp[i],dp[j]+1);
               max=Math.max(max,dp[i]);
           }
       }
       
       return max;
    }
}