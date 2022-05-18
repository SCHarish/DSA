import java.util.HashSet;

// Given a string s, find the length of the longest substring without repeating characters.


public class LongestSubStringWithoutRepatingChar {
    public static void main(String args[]){
        HashSet<Character> hset = new HashSet();
        String str = "abcahbdahc";
        int j=0, i=0, max = 0; // i is the slow pointer and j is the fast pointer..
        while(j < str.length()){
            if(!hset.contains(str.charAt(j))){
                hset.add(str.charAt(j)); //if set does not contain the char..add
                j++;
                max = Math.max(max, hset.size()); //update the max length
            } else{
                hset.remove(str.charAt(i));//if the char already exists in the set..remove until the char is removed from the set.
                //using slow pointer
                i++;
            }
        }
        System.out.println(max);
    }
}
