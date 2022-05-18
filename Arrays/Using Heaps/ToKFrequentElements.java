// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]
 

// Constraints:

// 1 <= nums.length <= 105
// k is in the range [1, the number of unique elements in the array].
// It is guaranteed that the answer is unique.
 

// Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
class ToKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        //Use hashmap to store the freq
        
        Map<Integer, Integer> hmap = new HashMap();
        
        for(int no : nums){
            hmap.put(no, hmap.getOrDefault(no, 0) + 1);
        }
        // PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
        //                  new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));
        
        for(Map.Entry<Integer, Integer> entry : hmap.entrySet()){
            minHeap.add(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        int result[] = new int[minHeap.size()];
        int z = 0;
        while(!minHeap.isEmpty()){
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            result[z] = entry.getKey();
            z++;
        }
        return result;
        
    }
}