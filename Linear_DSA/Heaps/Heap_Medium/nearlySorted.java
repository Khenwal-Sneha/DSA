package DSA.Linear_DSA.Heaps.Heap_Medium;

import java.util.PriorityQueue;

class Solution {
    public void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->a-b);
        
        for(int i=0;i<k && i<arr.length;i++) pq.add(arr[i]);
        
        int i=0;
        for(;i+k<arr.length;i++){
            pq.add(arr[i+k]);
            arr[i]=pq.poll();
        }
        
        while(!pq.isEmpty()){
            arr[i]=pq.poll();
            i++;
        }
    }
}

