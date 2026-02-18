package DSA.Non_Linear_DSA.Dynamic_Programming.DP_2D;

import java.util.Arrays;

public class UniquePathsInGrid {
    int[][] dp;
    public int uniquePaths(int[][] grid) {
        dp=new int[grid.length][grid[0].length];
        for(int[] d:dp) Arrays.fill(d,-1);
        return f(0,0,grid);
    }
    
    int f(int r,int c,int[][] grid){
        if(grid[r][c]==1) return 0;
        if(r==grid.length-1 && c==grid[0].length-1) return 1;
        
        if(dp[r][c]!=-1) return dp[r][c];
        
        int down=0;
        int right=0;
        if(r+1<grid.length) down=f(r+1,c,grid);
        if(c+1<grid[0].length) right=f(r,c+1,grid);
        
        return dp[r][c]=down+right;
    }
}
