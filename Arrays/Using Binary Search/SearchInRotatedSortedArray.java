//     Search in Rotated Sorted Array
// Technique: Sorted array can be searched with binary search

// .. apply binary search to find the pivot element
public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        //find the pivot element with iterative binary search variation
        
        int left = 0, right = nums.length-1;
        
        while(left < right){
            int mid = (left + right)/2;
            
            if(nums[mid] > nums[right]){//check mid element is greater that last element in the right, if so then change the left
                left = mid+1;
            } else{
                right = mid;
            }
        }
        
        
        //reset the left and right and check the which part of the array to search the target..
        int start = left; //left point to the pivot element.
        left = 0;
        right = nums.length-1;
        
        if(target >= nums[start] && target <= nums[right]){
            left = start;
        } else{
            right = start;
        }
        
        //Now normal iterative binary search the target element
        while(left <= right){
            int mid = (left+right)/2;
            
            if(nums[mid] == target)
                return mid;
            
            if(target > nums[mid]){
                left = mid+1;
            } else{
                right = mid-1;
            }
        }
        
        return -1;
    }
}        


// be careful with edge cases..
// - what if only one number in the array..
// - what if there are only two numbers in the array.. and how the binary search works in that case?
// - 
// midpoint = left + (right - left)/2 to avoid integer overflow...
