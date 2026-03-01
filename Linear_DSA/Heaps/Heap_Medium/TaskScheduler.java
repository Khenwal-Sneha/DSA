package DSA.Linear_DSA.Heaps.Heap_Medium;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// User function Template for Java

class Solution {
    static int leastInterval(int N, int k, char tasks[]) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        
        int[] hash=new int[26];
        for(char ch:tasks){
            hash[ch-'A']++;
        }
        
        for(int i=0;i<26;i++){
            if(hash[i]>0){
                pq.add(hash[i]);
            }
        }
        
        Queue<int[]> q=new LinkedList<>();
        
        int t=0;
        
        while(!pq.isEmpty() || !q.isEmpty()){
            t++;
            while(!q.isEmpty() && q.peek()[1] <= t){
                pq.add(q.poll()[0]);
            }
            if(!pq.isEmpty()){
                int ans=pq.poll()-1;
                if(ans!=0) q.add(new int[]{ans,t+k+1});
            }
        }
        
        return t;
    }
}

