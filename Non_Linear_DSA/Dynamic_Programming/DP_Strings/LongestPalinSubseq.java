class Solution {
    int[][] dp;
    public int longestPalinSubseq(String s) {
        dp=new int[s.length()][s.length()];
        String c=new String(s);
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        s=sb.toString();
        
        for(int[] d:dp) Arrays.fill(d,-1);
        
        return f(0,0,s,c);
    }
    
    int f(int i,int j,String s1,String s2){
        if(i>=s1.length() || j>=s2.length()) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        if(s1.charAt(i)==s2.charAt(j)) dp[i][j]=1+f(i+1,j+1,s1,s2);
        dp[i][j]=Math.max(dp[i][j],f(i+1,j,s1,s2));
        dp[i][j]=Math.max(dp[i][j],f(i,j+1,s1,s2));
        
        return dp[i][j];
    }
}