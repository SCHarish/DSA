// First Bad Version
// You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
// Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
// You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n, index = -1;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            
            boolean isBad = isBadVersion(mid);
            
            if(isBad){// even the bad index is found check the left range further to see if it is the start of the bad version…
                index = mid;//index will be updated everytime there exist a bad version in the left side of the range.
                right = mid-1;//that's why updating the right to mid-1
            } else{
                left = mid+1;
            }
            
         
        }
        
        return index;
    }
}