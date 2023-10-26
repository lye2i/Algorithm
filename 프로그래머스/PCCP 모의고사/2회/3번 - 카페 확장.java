import java.util.*;

class Solution {
    public int solution(int[] menu, int[] order, int k) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int answer = 0, idx = 0, n = order.length, time = 0;
        
        while(idx < n) {
            if(queue.isEmpty()) time = (idx*k) + menu[order[idx++]];
            else    time += menu[queue.poll()];
            
            while(idx < n && idx <= (time-1)/k) {
                queue.add(order[idx++]);
            }
            answer = Math.max(answer, queue.size());
        }
        
        return answer+1;
    }
}
