package DSA.Non_Linear_DSA.Dynamic_Programming.DP_Partition;

import java.util.Arrays;

// User function Template for Java
class Solution {
    int[][][] dp;
    int countWays(String s) {
        dp=new int[s.length()][s.length()][2];
        for(int[][] d:dp) for(int[] a:d) Arrays.fill(a,-1);
        
        return f(0,s.length()-1,1,s);
    }
    
    int f(int i,int j,int isTrue,String s){
        if(i==j){
            if(isTrue==1){
                if(s.charAt(i)=='T') return 1;
                return 0;
            }else{
                if(s.charAt(i)=='F') return 1;
                return 0;
            }
        }
        
        if(dp[i][j][isTrue]!=-1) return dp[i][j][isTrue];
        int cnt=0;
        for(int k=i+1;k<j;k+=2){
            char ch=s.charAt(k);
            int lt=f(i,k-1,1,s);
            int rt=f(k+1,j,1,s);
            int lf=f(i,k-1,0,s);
            int rf=f(k+1,j,0,s);
            if(isTrue==1){
                if(ch=='^'){
                    cnt+=(lf*rt)+(rf*lt);
                }else if(ch=='|'){
                    cnt+=(lf*rt)+(lt*rf)+(lt*rt);
                }else cnt+=(lt*rt);
            }else{
                if(ch=='^'){
                    cnt+=(lf*rf)+(rt*lt);
                }else if(ch=='|'){
                    cnt+=(lf*rf);
                }else cnt+=(lf*rf)+(lf*rt)+(lt*rf);
            }
        }
        
        return dp[i][j][isTrue]=cnt;
    }
}
