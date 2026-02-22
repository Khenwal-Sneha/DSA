class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        int[] dp=new int[arr.length];
        int[] hash=new int[arr.length];
        int max=0;
        
        for(int i=0;i<arr.length;i++){
            dp[i]=1;
            hash[i]=i;
            for(int j=0;j<i;j++){
               if(arr[j]<arr[i]){
                   if(dp[j]+1>dp[i]){
                       dp[i]=dp[j]+1;
                       hash[i]=j;
                   }
               }
               
               if(dp[i]>dp[max]) max=i;
                
            }
        }
        
        ArrayList<Integer> li=new ArrayList<>();
        
        while(hash[max]!=max){
            li.add(arr[max]);
            max=hash[max];
        }
        
        li.add(arr[max]);
        
        Collections.reverse(li);
        
        return li;
    }
}
