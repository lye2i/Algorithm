import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<Integer>();
        int answer = 0, n = order[0];
        
        for(int i=1; i<n; i++)
            stack.push(i);
        
        for(int i=0; i<order.length; i++) {
            if(order[i] == n) {
                answer++;
                n++;
            } else if(order[i] > n) {
                for(int j=n; j<order[i]; j++)
                    stack.push(j);   
                n = order[i]+1;
                answer++;
            } else {
                if(!stack.isEmpty() && order[i] == stack.peek()){
                    stack.pop();
                    answer++;
                }
                else    break;
            }
        }
        
        return answer;
    }
}