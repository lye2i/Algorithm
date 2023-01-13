import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(!stack.empty() && stack.peek() == c) stack.pop();
            else    stack.push(c);
        }
        
        if(stack.empty())   return 1;
        else    return 0;
    }
}