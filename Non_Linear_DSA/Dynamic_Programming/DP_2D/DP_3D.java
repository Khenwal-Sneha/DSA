package DSA.Non_Linear_DSA.Dynamic_Programming.DP_2D;

import java.util.Arrays;

class Solution {
    int[][][] dp;

    public int maxChocolate(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n][m][m];

        for(int[][] d : dp)
            for(int[] a : d)
                Arrays.fill(a, -1);

        return f(0, 0, m-1, grid);
    }

    int f(int r, int c1, int c2, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        if(r == n-1){
            if(c1 == c2)
                return grid[r][c1];
            else
                return grid[r][c1] + grid[r][c2];
        }

        if(dp[r][c1][c2] != -1)
            return dp[r][c1][c2];

        int max = Integer.MIN_VALUE;

        for(int d1 = -1; d1 <= 1; d1++){
            for(int d2 = -1; d2 <= 1; d2++){

                int nc1 = c1 + d1;
                int nc2 = c2 + d2;

                if(nc1 >= 0 && nc2 >= 0 && nc1 < m && nc2 < m){

                    int curr;
                    if(c1 == c2)
                        curr = grid[r][c1];
                    else
                        curr = grid[r][c1] + grid[r][c2];

                    curr += f(r+1, nc1, nc2, grid);

                    max = Math.max(max, curr);
                }
            }
        }

        return dp[r][c1][c2] = max;
    }
}
