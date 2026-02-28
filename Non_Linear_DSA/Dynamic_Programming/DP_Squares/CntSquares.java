package DSA.Non_Linear_DSA.Dynamic_Programming.DP_Squares;

// User function Template for Java

class Solution {
    public int countSquares(int N, int M, int mat[][]) {
        int cnt=0;
        for(int i=0;i<mat.length;i++){
            if(mat[i][0]==1) cnt++;
        }
        for(int i=1;i<mat[0].length;i++){
            if(mat[0][i]==1) cnt++;
        }
        
        for(int i=1;i<mat.length;i++){
            for(int j=1;j<mat[0].length;j++){
                if(mat[i][j]==0) continue;
                if(mat[i-1][j]>0 && mat[i-1][j-1]>0 && mat[i][j-1]>0) mat[i][j]=Math.min(mat[i-1][j-1],Math.min(mat[i-1][j],mat[i][j-1]))+1;
                else mat[i][j]=1;
                
                cnt+=mat[i][j];
            }
        }
        
        return cnt;
    }
}
