// Find First and Last Position of Element in Sorted Array

// Use binary Search..

// Find the start of the target in one set of range 
// Find the end of the target in another set of range..

// Do two binary searches separately to find both the start and end of the target..

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums.length == 0)
            return new int[]{-1, -1};
        
        int left = 0 , right = nums.length-1;
        int res[] = new int[2];
        res[0] = -1;
        res[1] = -1;
        while(left <= right){
            int mid = left + (right -left)/2;
            if(nums[mid] == target){ 
                res[0] = mid;
            }
            
            if(target <= nums[mid]){ 
                right = mid-1;//eventhough target is found  we still want to search in the left to find. the start of the range..that's why we assign right = mid-1;
            } else{
                left = mid+1;
            }
        }
        
       left = 0 ; right = nums.length-1;
        
        while(left <= right){
            int mid = left + (right -left)/2;
            if(nums[mid] == target){
                res[1] = mid;
            }
            
            if(target >= nums[mid]){
                left = mid+1;//eventhough target is found and we still want to search in the right to find. the start of the range..that's why we assign left = mid+1;
            } else{
                right = mid-1;
            }
        }
        
        return res;
    }
}
