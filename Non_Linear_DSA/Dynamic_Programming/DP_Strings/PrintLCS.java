// User function Template for Java

class Solution {
    static int[][] dp;
    StringBuilder sb;
    Set<String> li;
    public List<String> allLCS(String s1, String s2) {
        dp=new int[s1.length()][s2.length()];
        li=new HashSet<>();
        sb=new StringBuilder();
        for(int[] d:dp) Arrays.fill(d,-1);
        int len=f(0,0,s1,s2);
        
        printf(0,0,s1,s2,len);
        List<String> ans=new ArrayList<>(li);
        Collections.sort(ans);
        return ans;
    }
    
    static int f(int i,int j,String s1,String s2){
        if(i>=s1.length() || j>=s2.length()) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        int op1=0;
        if(s1.charAt(i)==s2.charAt(j)) op1=1+f(i+1,j+1,s1,s2);
        op1=Math.max(op1,f(i+1,j,s1,s2));
        op1=Math.max(op1,f(i,j+1,s1,s2));
        
        return dp[i][j]=op1;
    }
    
    void printf(int i,int j,String s1,String s2,int len){
        if(len==0){
            li.add(sb.toString());
            return;
        }
        if(i>=s1.length() || j>=s2.length()) return;
        
        if(s1.charAt(i)==s2.charAt(j)){
            sb.append(s1.charAt(i));
            printf(i+1,j+1,s1,s2,len-1);
            sb.deleteCharAt(sb.length()-1);
        }else{
            if(i+1<s1.length() && dp[i+1][j]==dp[i][j]) printf(i+1,j,s1,s2,len);
            if(j+1<s2.length() && dp[i][j]==dp[i][j+1]) printf(i,j+1,s1,s2,len);
        }
    }
}