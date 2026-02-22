class Solution {
    public int numberofLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int[] cnt=new int[nums.length];
        int max=0;
        int result=0;
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            cnt[i]=1;
            for(int j=0;j<i;j++){
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j]; // reset count
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j]; // add count
                    }
                }
            }

            if (dp[i] > max) {
                max= dp[i];
                result = cnt[i]; // reset result
            } else if (dp[i] == max) {
                result += cnt[i];
            }
        }

        return result;
    }
}