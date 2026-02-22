class Solution {
    public static int longestBitonicSequence(int n, int[] nums) {
        int[] dp1=new int[nums.length];
        int[] dp2=new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            dp1[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp1[i]=Math.max(dp1[i],dp1[j]+1);
                }
            }
        }
        
        for(int i=nums.length-1;i>=0;i--){
            dp2[i]=1;
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]<nums[i]){
                    dp2[i]=Math.max(dp2[i],dp2[j]+1);
                }
            }
        }
        
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(dp1[i]>1 && dp2[i]>1) max=Math.max(max,dp1[i]+dp2[i]-1);
        }
        
        return max;
    }
}
