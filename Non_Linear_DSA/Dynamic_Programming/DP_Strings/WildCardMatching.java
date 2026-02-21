class Solution {
    Boolean[][] dp;
    public boolean wildCard(String txt, String pat) {
        dp=new Boolean[txt.length()][pat.length()];
        
        return f(0,0,txt,pat);
    }
    
    boolean f(int i,int j,String txt,String pat){
        if(txt.length()<=i && j>=pat.length()) return true;
        if(i>=txt.length()){
            int k=j;
            while(k<pat.length() && pat.charAt(k)=='*') k++;
            if(k>=pat.length()) return true;
            return false;
        }
        
        if(j>=pat.length()) return false;
        
        if(dp[i][j]!=null) return dp[i][j];
        
        boolean ans=false;
        
        if(txt.charAt(i)==pat.charAt(j)) ans=ans || f(i+1,j+1,txt,pat);
        else if(pat.charAt(j)=='?') ans=ans || f(i+1,j+1,txt,pat);
        else if(pat.charAt(j)=='*'){
            ans=ans || f(i+1,j,txt,pat);
            ans=ans || f(i+1,j+1,txt,pat);
            ans=ans || f(i,j+1,txt,pat);
        }
        
        return dp[i][j]=ans;
    }
}