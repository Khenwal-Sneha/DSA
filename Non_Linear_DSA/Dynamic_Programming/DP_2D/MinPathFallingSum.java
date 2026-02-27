package DSA.Non_Linear_DSA.Dynamic_Programming.DP_2D;

import java.util.Arrays;

class Solution {
    int[][] dp;
    public int minFallingPathSum(int[][] mat) {
        int min=Integer.MAX_VALUE;
        dp=new int[mat.length][mat.length];
        for(int[] d:dp) Arrays.fill(d,-1);
        for(int i=0;i<mat.length;i++){
            min=Math.min(min,f(0,i,mat));
        }
        
        return min;
    }
    
    int f(int r,int c,int[][] mat){
        if(r==mat.length-1) return mat[r][c];
        
        if(dp[r][c]!=-1) return dp[r][c];
        int[] dr={1,1,1};
        int[] dc={0,-1,1};
        
        int min=1000000;
        for(int i=0;i<3;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            
            if(nr>=0 && nc>=0 && nr<mat.length && nc<mat.length) min=Math.min(min,mat[r][c]+f(nr,nc,mat));
        }
        
        return dp[r][c]=min;
    }
}
