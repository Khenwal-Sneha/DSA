package DSA.Linear_DSA.Heaps.Heap_Easy;

class Solution {

    public boolean countSub(long arr[], long n) {
        for(int i=arr.length-1;i>0;i--){
            if(arr[i]>arr[(i-1)/2]) return false;
        }
        
        return true;
    }
}
