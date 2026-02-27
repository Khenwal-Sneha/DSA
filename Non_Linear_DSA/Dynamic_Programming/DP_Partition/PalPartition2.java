package DSA.Non_Linear_DSA.Dynamic_Programming.DP_Partition;

import java.util.Arrays;

// User function Template for Java

class Solution {
    int[] dp;
    int palPartition(String s) {
        dp=new int[s.length()];
        Arrays.fill(dp,-1);
        
        return f(0,s);
    }
    
    int f(int i,String s){
        if(i>=s.length()) return 0;
        
        if(dp[i]!=-1) return dp[i];
        
        int min=Integer.MAX_VALUE;
        for(int k=i+1;k<=s.length();k++){
            int cnt=Integer.MAX_VALUE;
            if(isPalindrome(s.substring(i,k))){
                if(k==s.length()) cnt=0;
                else cnt=1+f(k,s);
            }
            min=Math.min(min,cnt);
        }
        
        return dp[i]=min;
    }
    
    boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        
        return true;
    }
}
