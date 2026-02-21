class Solution {
    int[][] dp;
    public int subseqCount(String txt, String pat) {
        dp=new int[txt.length()][pat.length()];
        for(int[] d:dp) Arrays.fill(d,-1);
        return f(0,0,txt,pat);
    }
    
    int f(int i,int j,String txt,String pat){
        if(j>=pat.length()) return 1;
        if(i>=txt.length()) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int ans=0;
        if(txt.charAt(i)==pat.charAt(j)) ans+=f(i+1,j+1,txt,pat);
        ans+=f(i+1,j,txt,pat);
        
        return dp[i][j]=ans;
    }
}