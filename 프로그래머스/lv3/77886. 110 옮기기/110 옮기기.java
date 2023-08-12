import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i=0; i<s.length; i++) {
            Stack<Character> stack = new Stack<Character>();
            int cnt = 0;
            
            for(int j=0; j<s[i].length(); j++) {
                stack.push(s[i].charAt(j));
                
                if(stack.peek() == '0' && stack.size() > 2) {
                    char c1 = stack.pop();
                    char c2 = stack.pop();
                    char c3 = stack.pop();
                    
                    if(c2 == '1' && c3 == '1')  cnt++;
                    else {
                        stack.push(c3);
                        stack.push(c2);
                        stack.push(c1);
                    }
                }
            }
            
            StringBuilder sb = new StringBuilder();
            int idx = -1, size = stack.size();
            while(size-- > 0) {
                if(idx == -1 && stack.peek() == '0')    idx = size;
                sb.insert(0, stack.pop());
            }
            
            int plus = idx == -1 ? 0 : ++idx;
            while(cnt-- > 0) {
                sb.insert(plus, "110");
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}