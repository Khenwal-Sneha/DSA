import java.util.Arrays;

class Solution {
    static int[][] dp;
    static int lcs(String s1, String s2) {
        dp=new int[s1.length()][s2.length()];
        for(int[] d:dp) Arrays.fill(d,-1);
        return f(0,0,s1,s2);
    }
    
    static int f(int i,int j,String s1,String s2){
        if(i>=s1.length() || j>=s2.length()) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        int op1=0;
        if(s1.charAt(i)==s2.charAt(j)) op1=1+f(i+1,j+1,s1,s2);
        op1=Math.max(op1,f(i+1,j+1,s1,s2));
        op1=Math.max(op1,f(i+1,j,s1,s2));
        op1=Math.max(op1,f(i,j+1,s1,s2));
        
        return dp[i][j]=op1;
    }
}