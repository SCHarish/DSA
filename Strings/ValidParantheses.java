// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
 

// Example 1:

// Input: s = "()"
// Output: true
// Example 2:

// Input: s = "()[]{}"
// Output: true
// Example 3:

// Input: s = "(]"
// Output: false
class ValidParantheses {
    public boolean isValid(String s) {
        Stack<Character> checker = new Stack<>();
        
        for(Character c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                checker.push(c);
            } else if(!checker.isEmpty() && ((c == ')' && checker.peek() == '(' )
                     || (c == '}' && checker.peek() == '{')
                      || (c == ']' && checker.peek() == '['))) {
                        
                          checker.pop();
                
            } else{
                return false;
            }
        }
        
        if(checker.isEmpty())
            return true;
        
        return false;     
    }
}