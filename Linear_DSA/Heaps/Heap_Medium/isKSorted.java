package DSA.Linear_DSA.Heaps.Heap_Medium;

import java.util.PriorityQueue;

// User function Template for Java

class Solution {
    static String isKSortedArray(int arr[], int n, int k) {
        // code here
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->arr[a]-arr[b]);
        
        for(int i=0;i<arr.length;i++){
            pq.add(i);
        }
        
        int i=0;
        
        while(!pq.isEmpty()){
            int curr=pq.poll();
            if(Math.abs(i-curr)>k) return "No";
            i++;
        }
        
        return "Yes";
    }
}
