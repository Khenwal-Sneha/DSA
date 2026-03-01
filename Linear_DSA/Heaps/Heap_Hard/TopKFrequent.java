package DSA.Linear_DSA.Heaps.Heap_Hard;

import java.util.*;

class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Count frequencies
        for(int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Sort elements based on frequency descending, then value descending
        List<Integer> keys = new ArrayList<>(freqMap.keySet());
        keys.sort((a, b) -> {
            if(freqMap.get(b) != freqMap.get(a))
                return freqMap.get(b) - freqMap.get(a); // higher frequency first
            return b - a; // tie-breaker: higher value first
        });

        // Pick top k
        for(int i = 0; i < k; i++) {
            result.add(keys.get(i));
        }

        return result;
    }
}

