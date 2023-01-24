import java.util.*;

class Solution {
    
    public boolean check(String p) {
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '(')  stack.push('(');
            else if(!stack.isEmpty() && stack.peek() == '(' && p.charAt(i) == ')' ) stack.pop();
        }
       
        if(stack.isEmpty()) return true;
        else    return false;
    }
    
    public String change(String p) {
        if(p.length() == 0) return "";
        
        String u = "", v = "";
        int left = 0, right = 0;
        
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '(')  left++;
            else    right++;

            if(left == right) {
                u = p.substring(0, i+1);
                v = p.substring(i+1, p.length());
                break;
            }
        }
                
        if(check(u))    return u + change(v);
        
        v = "(" + change(v) + ")";
        for(int i=1; i<u.length()-1; i++){
            if(u.charAt(i) == '(')  v += ")";
            else    v += "(";
        }
        
        return v;
    }
    
    public String solution(String p) {
        if(check(p))    return p;
        return change(p);
    }
}