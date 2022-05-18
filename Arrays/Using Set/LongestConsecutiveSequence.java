// https://www.youtube.com/watch?v=P6RZZMu_maU
// Use Set datastructure
// Add all the elements to hashset
// Iterate the array and check if it is the start of the sequence..(by checking if the previous no. is there)
// If there is no previous no. we can consider it as start

class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        //Use hash set put all the elements so that we can check whether start of the sequence exist in O(1) time..
        Set<Integer> set = new HashSet();
        for(int i : nums){
            set.add(i);
        }
        
        int longest_consecutive = 0;
        
        //Iterate the array elements one by one and check if it is the start of the sequence
        for(int no : nums){
            if(!set.contains(no-1)){ //if the set does not have the previous number which means it is the start of the sequence and then we can start to count the consecutive numbers present after the current number
                int currentStreak = 1;
                int tmp_no = no+1; //storing the next number to check if it is present in the set
                while(set.contains(tmp_no)){
                    currentStreak++;
                    tmp_no++;
                }
                longest_consecutive = Math.max(longest_consecutive, currentStreak);
            }
            
            
        }
        
        return longest_consecutive;
    }
}