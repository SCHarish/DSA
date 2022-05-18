// You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

// Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.

 

// Example 1:

// Input: flowerbed = [1,0,0,0,1], n = 1
// Output: true
// Example 2:

// Input: flowerbed = [1,0,0,0,1], n = 2
// Output: false
 

// Constraints:

// 1 <= flowerbed.length <= 2 * 104
// flowerbed[i] is 0 or 1.
// There are no two adjacent flowers in flowerbed.
// 0 <= n <= flowerbed.length
public class canPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i=0;
        
        while(i < flowerbed.length){
            if(n == 0)
                return true;
            if(flowerbed.length == 1 && flowerbed[i] != 1){
                n--;
                i=i+2;
            } 
            else if(i == 0 && i + 1 < flowerbed.length && flowerbed[i] == 0 && flowerbed[i+1] != 1){
                n--;
                i=i+2;
            } else if(i == flowerbed.length-1 && i-1 >= 0 && flowerbed[i] == 0 && flowerbed[i-1] != 1 ){
                n--;
                i=i+2;
            } else if (i-1 >= 0 && i+1 < flowerbed.length && flowerbed[i-1] != 1 && flowerbed[i+1] != 1 && flowerbed[i] == 0){
                n--;
                i=i+2;
            } else{
                i++;
            }
        }
        
        if(n==0)
            return true;
        
        return false;
    }

    public boolean canPlaceFlowersV2(int[] flowerbed, int n) {
        if (n==0) return true;
        int nn = 0;
        int i=0;
        while (i<flowerbed.length) {
            if (flowerbed[i]==1) i+=2;
            else if ((i==0 || flowerbed[i-1] ==0) && ( i==flowerbed.length-1||flowerbed[i+1] ==0)) { //we are sure that flowerbed has the value 0 here 
                if (++nn==n) return true;
                i+=2;
            }
            else 
                i++;
        }
        return false;
    }

    public boolean canPlaceFlowersV3(int[] flowerbed, int n) {
        int count = 0;
        for(int i = 0; i < flowerbed.length && count < n; i++) {
            if(flowerbed[i] == 0) {
	     //get next and prev flower bed slot values. If i lies at the ends the next and prev are considered as 0. 
               int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1]; 
               int prev = (i == 0) ? 0 : flowerbed[i - 1];
               if(next == 0 && prev == 0) {
                   flowerbed[i] = 1;
                   count++;
               }
            }
        }
        
        return count == n;
    }
}



