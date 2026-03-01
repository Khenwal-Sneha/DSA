package DSA.Linear_DSA.Heaps.Heap_Medium;

import java.util.PriorityQueue;

// User function Template for Java

class Solution {
    static int[] replaceWithRank(int arr[], int N) {
        // code here
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        
        for(int i=0;i<arr.length;i++){
            pq.offer(new int[]{arr[i],i});
        }
        
        int cnt=1;
        while(!pq.isEmpty()){
            int[] num=pq.poll();
            arr[num[1]]=cnt;
            if(!pq.isEmpty() && pq.peek()[0]!=num[0]) cnt++;
        }
        
        return arr;
    }
}
