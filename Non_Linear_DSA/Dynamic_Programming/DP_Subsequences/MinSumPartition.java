class Solution {
    Boolean dp[][];
    public int minDifference(int arr[]) {
        int sum=0;
        for(int a:arr) sum+=a;
        dp=new Boolean[arr.length][sum+1];
        
        for(int tar=0;tar<=sum;tar++){
            f(0,arr,tar);
        }
        
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<=sum;i++){
            if(dp[0][i]!=null && dp[0][i]==true){
                int s1=i;
                int s2=sum-s1;
                
                ans=Math.min(ans,Math.abs(s2-s1));
            }
        }
        
        return ans;
    }
    
    boolean f(int i,int[] arr,int sum){
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
