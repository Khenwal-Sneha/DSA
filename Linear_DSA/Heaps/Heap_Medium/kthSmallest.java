package DSA.Linear_DSA.Heaps.Heap_Medium;

import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[] arr, int k) {
        if(k>arr.length) return -1;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        
        for(int i=0;i<arr.length;i++){
            if(pq.size()==k && arr[i]<pq.peek()){
                pq.poll();
                pq.offer(arr[i]);
            }else if(pq.size()<k) pq.offer(arr[i]);
        }
        
        return pq.poll();
    }
}

