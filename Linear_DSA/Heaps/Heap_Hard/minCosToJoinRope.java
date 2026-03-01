package DSA.Linear_DSA.Heaps.Heap_Hard;

import java.util.PriorityQueue;

class Solution {
    public int minCost(int[] arr) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> a-b);
        
        for(int a:arr) pq.add(a);
        int cost=0;
        while(pq.size()!=1){
            int a=pq.poll();
            int b=pq.poll();
            cost+=(a+b);
            pq.add(a+b);
        }
        
        return cost;
    }
}
