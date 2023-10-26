import java.util.*;

class Solution {
    public int solution(int[] ability, int number) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int answer = 0;
        
        for(int a : ability) {
            pq.add(a);
        }
        
        while(number-- > 0) {
            int sum = pq.poll() + pq.poll();
            pq.add(sum);
            pq.add(sum);
        }
        
        while(!pq.isEmpty()) {
            answer += pq.poll();
        }
        return answer;
    }
}
