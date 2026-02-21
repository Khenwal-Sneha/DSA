class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][] dp=new int[2][k+1];

        //Base case(If I hold a stock I can sell it at last idx no matter what)
        for(int i=1;i<k+1;i++){
            dp[1][i]=prices[n-1];
        }

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<2;j++){
                for(int c=1;c<k+1;c++){
                    if(j==1){
                        //If I hold a stock
                        int sellStock=prices[i]+dp[0][c-1];
                        int keepStock=dp[1][c];
                        dp[j][c]=Math.max(sellStock,keepStock);
                    }else{
                        //I dont hold a stock
                        int buyStock=-prices[i]+dp[1][c];
                        int dontBuy=dp[0][c];
                        dp[j][c]=Math.max(buyStock,dontBuy);
                    }
                }
            }
        }
        return dp[0][k];
    }
}