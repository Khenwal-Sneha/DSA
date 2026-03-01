package DSA.Linear_DSA.Heaps.Heap_Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// User function Template for Java

class Solution {
    boolean isStraightHand(int N, int k, int arr[]) {
        if(arr.length%k!=0) return false;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->a-b);
        for(int a:arr) pq.add(a);
        
        while(!pq.isEmpty()){
            List<Integer> li=new ArrayList<>();
            int cnt=0;
            int prev=-1;
            while(!pq.isEmpty() && cnt<k){
                int ans=pq.poll();
                if(prev==-1 || ans==prev+1){
                    cnt++;
                    prev=ans;
                }else{
                    if(ans==prev) li.add(ans);
                    else return false;
                }
            }
            
            if(pq.isEmpty() && cnt<k) return false;
            
            for(int a:li) pq.add(a);
        }
        
        return true;
    }
}

