package DSA.Non_Linear_DSA.Dynamic_Programming.DP_2D;

import java.util.Arrays;

public class NinjaTraining {
    int[][] dp;
    public int maximumPoints(int mat[][]) {
        dp=new int[mat.length][4];
        
        for(int[] d:dp) Arrays.fill(d,-1);
        return f(0,-1,mat);
        
    }
    
    int f(int i,int prev,int[][] mat){
        if(i>=mat.length) return 0;
        
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int run=0;
        int fight=0;
        int learn=0;
        
        if(prev!=0) run=mat[i][0]+f(i+1,0,mat);
        if(prev!=1) fight=mat[i][1]+f(i+1,1,mat);
        if(prev!=2) learn=mat[i][2]+f(i+1,2,mat);
        
        return dp[i][prev+1]=Math.max(run,Math.max(fight,learn));
    }
}

//Tabulation with optimised space
class Solution {
    int[] dp;
    public int maximumPoints(int mat[][]) {
        dp=new int[4];
        
        for(int i=mat.length-1;i>=0;i--){
            int[] temp=new int[4];
            for(int j=0;j<4;j++){
                int run=0;
                int fight=0;
                int learn=0;
        
                if(j!=1) run=mat[i][0]+dp[1];
                if(j!=2) fight=mat[i][1]+dp[2];
                if(j!=3) learn=mat[i][2]+dp[3];
                
                temp[j]=Math.max(run,Math.max(fight,learn));
            }
            dp=temp;
        }
        
        return dp[0];
    }
}
