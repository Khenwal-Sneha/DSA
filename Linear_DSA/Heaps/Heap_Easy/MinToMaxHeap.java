package DSA.Linear_DSA.Heaps.Heap_Easy;

class Solution {
    void convertMinToMaxHeap(int N, int arr[]) {
        
        // Start from last non-leaf node
        for (int i = N/2 - 1; i >= 0; i--) {
            heapifyDownMax(arr, N, i);
        }
    }
    
    private void heapifyDownMax(int arr[], int size, int i) {
        
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < size && arr[left] > arr[largest]) {
                largest = left;
            }

            if (right < size && arr[right] > arr[largest]) {
                largest = right;
            }

            if (largest != i) {
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                i = largest;
            } else {
                break;
            }
        }
    }
}
