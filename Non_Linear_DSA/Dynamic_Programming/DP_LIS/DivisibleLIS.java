import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp=new int[nums.length];
        int[] parent=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            parent[i]=-1;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    parent[i]=j;
                }
            }
        }

        List<Integer> li=new ArrayList<>();
        int max=0;
        int idx=-1;
        for(int i=0;i<nums.length;i++){
            if(max<dp[i]){
                max=dp[i];
                idx=i;
            }
        }

        li.add(nums[idx]);
        while(parent[idx]!=-1){
            idx=parent[idx];
            li.add(0,nums[idx]);
        }

        return li;
    }
}