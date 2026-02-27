import java.util.Arrays;

class Solution {
    int[][] dp;
    public int cutRod(int[] price) {
        dp=new int[price.length][price.length+1];
        for(int[] a:dp) Arrays.fill(a,-1);
        return f(0,price,0);
    }
    
    int f(int i,int[] price,int len){
        if(len>price.length) return Integer.MIN_VALUE;
        if(i==price.length){
            if(len==price.length) return 0;
            return Integer.MIN_VALUE;
        }
        if(dp[i][len]!=-1) return dp[i][len];
        int op1=price[i]+f(i,price,len+i+1);
        int op2=f(i+1,price,len);
        
        return dp[i][len]=Math.max(op1,op2);
    }
}