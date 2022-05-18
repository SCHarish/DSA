class Sort0s1s2s {
    public void sortColors(int[] nums) {
        //use three pointers
        int low=0, high=nums.length-1, mid = 0;
        if(nums.length == 1)
            return;
        while(mid <= high){
              if(nums[mid] == 0){
                  //swap with low
                  int tmp = nums[mid];
                  nums[mid] = nums[low];
                  nums[low] = tmp;
                  low++;
                  mid++;
              }  else if(nums[mid] == 2){
                  int tmp = nums[mid];
                  nums[mid] = nums[high];
                  nums[high] = tmp;
                  high--;
              } else{ //in the case of 1
                  mid++;
              }
        }
    }
}