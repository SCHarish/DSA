// Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

// Return the sum of the three integers.

// You may assume that each input would have exactly one solution.

 

// Example 1:

// Input: nums = [-1,2,1,-4], target = 1
// Output: 2
// Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// Example 2:

// Input: nums = [0,0,0], target = 1
// Output: 0

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE, sum = 0;
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length -2;i++){
            int left = i+1, right = nums.length - 1;
            
            
            while(left < right){
                int threeSum = nums[i] + nums[left] + nums[right];
                
                int curr_diff = Math.abs(target - threeSum);
                
                if(curr_diff < diff){   
                    diff = curr_diff;
                    sum = threeSum;
                }
                
                if(threeSum > target)
                    right--;
                else
                    left++;
            }
        }
        
        return sum;
    }
}