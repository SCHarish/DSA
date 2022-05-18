// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

// Example 1:


// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
// Example 2:

// Input: height = [4,2,0,3,2,5]
// Output: 9
 

// Constraints:

// n == height.length
// 1 <= n <= 2 * 104
// 0 <= height[i] <= 105

class TrappingRainWater {
    public int trap(int[] height) {
        //calculate prefix sum
        
        int prefix_sum[] = new int[height.length];
        int suffix_sum[] = new int[height.length];
        
        //iterate the array to calc prefix sum from left to right
        int highest_from_left = height[0];
        prefix_sum[0] = highest_from_left;
        for(int i=1; i< height.length; i++){
            if(height[i] > highest_from_left){
                prefix_sum[i] = height[i];
                highest_from_left = height[i];
            } else{
                prefix_sum[i] = highest_from_left;
            }
        }
        
        //iterate the array to calc suffix sum from right to left
        int highest_from_right = height[height.length-1];
        suffix_sum[height.length-1] = highest_from_right;
        for(int i=height.length-2; i>= 0; i--){
            if(height[i] > highest_from_right){
                suffix_sum[i] = height[i];
                highest_from_right = height[i];
            } else{
                suffix_sum[i] = highest_from_right;
            }
        }
        
        int max = 0;
        for(int i=0;i<height.length;i++){
            int left_max = prefix_sum[i];
            int right_max = suffix_sum[i];
            
            //take the min of the left max and right max and substract the current block height so that the capacity of the current block can be found..
            int water_stored = Math.min(left_max, right_max) - height[i]; //height of that block
            if(water_stored > 0)
                max += water_stored;
        }
        
        return max;
    }
}