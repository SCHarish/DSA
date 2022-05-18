// Given an integer array nums, return the number of elements that have both a strictly smaller and a strictly greater element appear in nums.

 

// Example 1:

// Input: nums = [11,7,2,15]
// Output: 2
// Explanation: The element 7 has the element 2 strictly smaller than it and the element 11 strictly greater than it.
// Element 11 has element 7 strictly smaller than it and element 15 strictly greater than it.
// In total there are 2 elements having both a strictly smaller and a strictly greater element appear in nums.
// Example 2:

// Input: nums = [-3,3,3,90]
// Output: 2
// Explanation: The element 3 has the element -3 strictly smaller than it and the element 90 strictly greater than it.
// Since there are two elements with the value 3, in total there are 2 elements having both a strictly smaller and a strictly greater element appear in nums.

class CountStrictlyGreatAndSmall {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int low = 0, high = nums.length-1;
            boolean lowFound = false, highFound = false;
            
            while(low < i && high > i){
                
                if(!lowFound){
                    if(nums[low] < nums[i]){
                        lowFound = true;
                    } 
                }
                
                if(!highFound){ 
                    if(nums[high] > nums[i]){
                        highFound = true;
                    }
                }
                low++;
                high--;
            }
            
            if(lowFound && highFound){
                count++;
            }
        }
        
        return count;
    }
}