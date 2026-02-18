package DSA.Non_Linear_DSA.Dynamic_Programming.DP_2D;

import java.util.Arrays;
//Only down and right moves are allowed, find the minimum path sum from top left to bottom right of a grid
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int[] row:dp) Arrays.fill(row,-1);

        return (int)f(m-1,n-1,dp,grid);
    }

    long f(int r,int c,int[][] dp,int[][] grid){
        if(r==0 && c==0){
            return grid[r][c];
        }

        if(r<0 || c<0){
            return Integer.MAX_VALUE;
        }
        if(dp[r][c]!=-1) return dp[r][c];
        long up=grid[r][c]+f(r-1,c,dp,grid);
        long left=grid[r][c]+f(r,c-1,dp,grid);

        return dp[r][c]=(int)Math.min(up,left);
    }
}
