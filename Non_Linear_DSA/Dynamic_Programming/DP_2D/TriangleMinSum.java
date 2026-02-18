package DSA.Non_Linear_DSA.Dynamic_Programming.DP_2D;

import java.util.ArrayList;
import java.util.Arrays;

public class TriangleMinSum {
    int[][] dp;
    public int minPathSum(ArrayList<ArrayList<Integer>> triangle) {
        dp=new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int[] d:dp) Arrays.fill(d,-1);
        return f(0,0,triangle);
    }
    
    int f(int r,int c,ArrayList<ArrayList<Integer>> tri){
        if(r==tri.size()-1) return tri.get(r).get(c);
        
        if(dp[r][c]!=-1) return dp[r][c];
        int st=100000;
        int st2=100000;
        
        st=tri.get(r).get(c) + f(r+1,c,tri);
        
        st2=tri.get(r).get(c) + f(r+1,c+1,tri);
        
        return dp[r][c]=Math.min(st,st2);
    }
}
