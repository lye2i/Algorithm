import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                if(stack.empty() || stack.peek()=='(')
                    stack.push(s.charAt(i));
                else return false;
            } else {
                if(stack.empty())   return false;
                else stack.pop();
            }
        }
        
        if(stack.empty())   return true;
        else return false;
    }
}