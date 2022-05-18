// Find All Lonely Numbers in the Array
// User Accepted:7420
// User Tried:7993
// Total Accepted:7558
// Total Submissions:13036
// Difficulty:Medium
// You are given an integer array nums. A number x is lonely when it appears only once, and no adjacent numbers (i.e. x + 1 and x - 1) appear in the array.

// Return all lonely numbers in nums. You may return the answer in any order.

 

// Example 1:

// Input: nums = [10,6,5,8]
// Output: [10,8]
// Explanation: 
// - 10 is a lonely number since it appears exactly once and 9 and 11 does not appear in nums.
// - 8 is a lonely number since it appears exactly once and 7 and 9 does not appear in nums.
// - 5 is not a lonely number since 6 appears in nums and vice versa.
// Hence, the lonely numbers in nums are [10, 8].
// Note that [8, 10] may also be returned.
// Example 2:

// Input: nums = [1,3,5,3]
// Output: [1,5]
// Explanation: 
// - 1 is a lonely number since it appears exactly once and 0 and 2 does not appear in nums.
// - 5 is a lonely number since it appears exactly once and 4 and 6 does not appear in nums.
// - 3 is not a lonely number since it appears twice.
// Hence, the lonely numbers in nums are [1, 5].
// Note that [5, 1] may also be returned.
class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> result = new ArrayList();
        
        HashMap<Integer, Integer> hmap = new HashMap();
        
        for(int i=0; i < nums.length; i++){
            if(!hmap.containsKey(nums[i])){
                hmap.put(nums[i], 1);
            } else{
                hmap.put(nums[i], hmap.get(nums[i]) + 1);
            }
        }
        
        for(int i=0;i<nums.length;i++){
            int no = hmap.get(nums[i]);
            if(no == 1 && !hmap.containsKey(nums[i] - 1) && !hmap.containsKey(nums[i] + 1)){
                result.add(nums[i]);
            }
        }
        
        return result;
    }
}