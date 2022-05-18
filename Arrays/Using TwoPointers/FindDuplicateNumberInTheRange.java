// Find Duplicate number
// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
// There is only one repeated number in nums, return this repeated number.
// You must solve the problem without modifying the array nums and uses only constant extra space.

// Discussion:
// Use cycle detection algorithm in linked list..

// First detect there exist a cycle 
// Try to find the starting point of the cycle..

// Use slow and fast pointer to detect the cycle..
// Then move the fast pointer to the start and start to move both slow and fast pointers at the same pace..the point where it meets is the start of the cycle.
class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
       //Use floyd cycle detection algorithm
        //check if array size is greater than 1, if size is 1 there are no duplicates return -1
        
        if(nums.length > 1){
            //Assign slow to first pos and fast to se
            int slow = nums[0];
            int fast = nums[nums[0]];

            //Move slow one pos and fast two pos
            while(slow != fast){
                slow = nums[slow];
                fast = nums[nums[fast]];//moving two positions
            }
            
            // At this point we detect there exist a cycle. Now we need to check if this is the start of the cycle.
            //assign fast to the start 0th index and move the slow and fast at the same pace...
            fast = 0;
            
            while(slow != fast){
                slow = nums[slow];
                fast = nums[fast];
            }
            
            return slow;
        }
        
        return -1;
    }
}