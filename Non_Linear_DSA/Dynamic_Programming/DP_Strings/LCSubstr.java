class Solution {
    int max;
    int[][] dp;
    public int longCommSubstr(String s1, String s2) {
        dp=new int[s1.length()+1][s2.length()+1];
        for(int i=s1.length()-1;i>=0;i--){
            for(int j=s2.length()-1;j>=0;j--){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=1+dp[i+1][j+1];
                    max=Math.max(max,dp[i][j]);
                }else dp[i][j]=0;
            }
        }
        return max;
    }
}