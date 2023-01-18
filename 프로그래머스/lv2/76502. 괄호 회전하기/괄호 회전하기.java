import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0; i<s.length(); i++){      
            for(int j=i; j<s.length(); j++){
                if(stack.empty() || s.charAt(j) == '[' || s.charAt(j) == '(' || s.charAt(j) == '{')   stack.push(s.charAt(j));
                else {
                    switch(s.charAt(j)){
                        case ']':
                            if(stack.peek() == '[') stack.pop();
                            break;
                        case '}' :
                            if(stack.peek() == '{') stack.pop();
                            break;
                        case ')' :
                            if(stack.peek() == '(') stack.pop();
                            break;
                        default:
                            break;
                    }
                }
            }
            
            for(int j=0; j<i; j++){
                if(stack.empty() || s.charAt(j) == '[' || s.charAt(j) == '(' || s.charAt(j) == '{')   stack.push(s.charAt(j));
                else {
                    switch(s.charAt(j)){
                        case ']':
                            if(stack.peek() == '[') stack.pop();
                            break;
                        case '}' :
                            if(stack.peek() == '{') stack.pop();
                            break;
                        case ')' :
                            if(stack.peek() == '(') stack.pop();
                            break;
                        default:
                            break;
                    }
                }
            }
            
            if(stack.empty())   answer++;
            stack.clear();
        }
        return answer;
    }
}