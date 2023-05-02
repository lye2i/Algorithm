import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;
        
        for(int i : works) {
            pq.add(i);
        }
        
        while(n-- > 0 && !pq.isEmpty()) {
            int i = pq.poll();
            if(--i != 0)    pq.add(i);
        }
        
        while(!pq.isEmpty()) {
            answer += pq.peek()*pq.poll();
        }
        return answer;
    }
}