import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        
        for(int i=1; i<arr.length; i++){
            if(stack.peek() != arr[i]) {
                queue.offer(stack.pop());
                stack.push(arr[i]);
            }
        }
        
        queue.offer(stack.pop());
        int[] answer = new int[queue.size()];
        int l = 0;
        while(!queue.isEmpty()){
            answer[l++] = queue.poll();
        }
        return answer;
    }
}