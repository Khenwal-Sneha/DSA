package DSA.Linear_DSA.Heaps.Heap_Medium;

import java.util.PriorityQueue;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
class Solution {
    Node mergeKLists(Node[] arr) {
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->a.data-b.data);
        
        for(Node n:arr) pq.add(n);
        Node dummy=new Node(-1);
        Node curr=dummy;
        while(!pq.isEmpty()){
            curr.next=pq.poll();
            curr=curr.next;
            if(curr.next!=null) pq.add(curr.next);
        }
        
        return dummy.next;
    }
}
