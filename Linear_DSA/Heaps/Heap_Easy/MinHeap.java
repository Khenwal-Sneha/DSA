package DSA.Linear_DSA.Heaps.Heap_Easy;

import java.util.ArrayList;
import java.util.List;

class minHeap {
    List<Integer> li;
    public minHeap() {
        li=new ArrayList<>();
    }

    public void push(int x) {
        li.add(x);
        heapifyUp(li.size()-1);
    }

    public void pop() {
        li.set(0,li.get(li.size()-1));
        li.remove(li.size()-1);
        heapifyDown(0);
    }

    public int peek() {
        if(li.size()==0) return -1;
        
        return li.get(0);
    }

    public int size() {
        return li.size();
    }
    
    public void heapifyUp(int i) {
    while (i > 0) {
        int parent = (i - 1) / 2;

        if (li.get(i) < li.get(parent)) {
            int temp=li.get(i);
            li.set(i,li.get(parent));
            li.set(parent,temp);
            i = parent;
        } else {
            break;
        }
    }
}
    
    public void heapifyDown(int i){
        if(li.size()==0) return;
        if(i>li.size()-1) return;
        int mv=li.get(i);
        int lv=2*i+1<=li.size()-1 ? li.get(2*i+1) : Integer.MAX_VALUE;
        int rv=2*i+2<=li.size()-1 ? li.get(2*i+2) : Integer.MAX_VALUE;
        int smallest=i;
        boolean lc=false;
        int val=mv;
        if(lv<val){
            smallest=2*i+1;
            val=lv;
            lc=true;
        }
        
        if(rv<val){
            smallest=2*i+2;
            val=rv;
            lc=false;
        }
        
        if(smallest!=i){
            if(lc){
                li.set(i,lv);
                li.set(2*i+1,mv);
                heapifyDown(2*i+1);
            }else{
                li.set(i,rv);
                li.set(2*i+2,mv);
                heapifyDown(2*i+2);
            }
        }
    }
}
