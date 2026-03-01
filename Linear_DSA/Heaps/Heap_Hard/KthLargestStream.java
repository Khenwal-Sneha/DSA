package DSA.Linear_DSA.Heaps.Heap_Hard;

import java.util.PriorityQueue;

class Solution {
    int[] kthLargest(int k, int[] arr, int n) {
        int[] ans=new int[arr.length];
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> a-b);
        
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            if(pq.size()<k){
                ans[i]=-1;
            }else if(pq.size()==k){
                ans[i]=pq.peek();
            }else{
                pq.poll();
                ans[i]=pq.peek();
            }
        }
        
        return ans;
    }
};
