import java.util.Arrays;

class Solution {
    int[][] dp;
    public int editDistance(String s1, String s2) {
        dp=new int[s1.length()][s2.length()];
        for(int[] d:dp) Arrays.fill(d,-1);
        
        return f(0,0,s1,s2);
    }
    
    int f(int i,int j,String s1,String s2){
            if(i>=s1.length()){
                return s2.length()-j;
            }
            
            if(j>=s2.length()) return s1.length()-i;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int ans=1000000;
        
        if(s1.charAt(i)==s2.charAt(j)) ans=Math.min(ans,f(i+1,j+1,s1,s2));
        ans=Math.min(ans,1+f(i,j+1,s1,s2));
        ans=Math.min(ans,1+f(i+1,j+1,s1,s2));
        ans=Math.min(ans,1+f(i+1,j,s1,s2));
        
        return dp[i][j]=ans;
    }
}