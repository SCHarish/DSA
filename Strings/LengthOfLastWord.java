// Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.

// A word is a maximal substring consisting of non-space characters only.

 

// Example 1:

// Input: s = "Hello World"
// Output: 5
// Explanation: The last word is "World" with length 5.
// Example 2:

// Input: s = "   fly me   to   the moon  "
// Output: 4
// Explanation: The last word is "moon" with length 4.
// Example 3:

// Input: s = "luffy is still joyboy"
// Output: 6
// Explanation: The last word is "joyboy" with length 6.
 

// Constraints:

// 1 <= s.length <= 104
// s consists of only English letters and spaces ' '.
// There will be at least one word in s.

class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        
        StringBuilder strBuilder = new StringBuilder("");
        String lastFoundString = "";
        
        //Iterate the string backwards char by char from end to start and collect the last word..
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i) != ' '){
                strBuilder.append(s.charAt(i));
            } else{
                
                lastFoundString = strBuilder.toString();
                if(!lastFoundString.isEmpty())
                    break; //if an another space encountered break after the string found
            }
        }
        
        //As the given string s contains atleast one word therefore the lastFoundString cannot be empty...
        lastFoundString = strBuilder.toString();
        
        
        return lastFoundString.length();
    }
}