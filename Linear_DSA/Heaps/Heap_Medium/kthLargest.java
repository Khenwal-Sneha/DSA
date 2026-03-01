package DSA.Linear_DSA.Heaps.Heap_Medium;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    // Function to return kth largest element from an array.
    public static int KthLargest(int arr[], int k) {
        int n = arr.length;
        // implementing MinHeap using priority queue.
        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            // if size of priority queue becomes equal to k and top
            // element is smaller than arr[i], we pop the front
            // element and push arr[i] in priority queue.
            if (pq.size() == k && pq.peek() < arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }
            // else we just push arr[i] in priority queue.
            else if (pq.size() < k)
                pq.add(arr[i]);
        }
        // returning the top element of priority queue.
        return pq.peek();
    }
}
