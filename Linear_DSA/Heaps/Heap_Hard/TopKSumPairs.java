package DSA.Linear_DSA.Heaps.Heap_Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((i,j)->j[2]-i[2]);
        ArrayList<Integer> li=new ArrayList<>();
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        
        int i1=a.length-1;
        int i2=b.length-1;
        
        HashSet<String> hset=new HashSet<>();
        hset.add(i1 + " " +i2);
        pq.add(new int[]{i1,i2,a[i1]+b[i2]});
        while(li.size()!=k){
            int[] an=pq.poll();
            i1=an[0];
            i2=an[1];
            li.add(an[2]);
            int na=i1-1;
            int nb=i2-1;
            if(!hset.contains(na + " " + i2) && na>=0 && i2>=0){
                pq.add(new int[]{na,i2,a[na]+b[i2]});
                hset.add(na + " " + i2);
            }
            
            if(!hset.contains(i1 + " " + nb) && i1>=0 && nb>=0){
                pq.add(new int[]{i1,nb,a[i1]+b[nb]});
                hset.add(i1 + " " + nb);
            }
            
            if(!hset.contains(na + " " + nb) && na>=0 && nb>=0){
                pq.add(new int[]{na,nb,a[na]+b[nb]});
                hset.add(na + " " + nb);
            }
        }
        return li;
    }
}
