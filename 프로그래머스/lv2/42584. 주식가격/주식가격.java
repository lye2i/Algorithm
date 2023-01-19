import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int [] answer = new int[n];
        Stack<int[]> stack = new Stack<>();
        
        for(int i=0; i<n; i++){
            if(stack.isEmpty()){
                stack.push(new int[]{prices[i],i});
                continue;
            }
            
            if(stack.peek()[0] <= prices[i])
                stack.push(new int[]{prices[i],i});
            else{
                while(!stack.isEmpty() && stack.peek()[0]>prices[i]){
                    answer[stack.peek()[1]] = i-stack.peek()[1];
                    stack.pop();
                }
                stack.push(new int[]{prices[i],i});
            }
        }
        
        while(!stack.isEmpty()){
            answer[stack.peek()[1]] = (n-1)-stack.peek()[1];
            stack.pop();
        }
        return answer;
    }
}