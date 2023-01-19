import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(pq.peek() < K) {
            if(pq.size() == 1){
                answer = -1;
                break;
            }
            answer++;
            pq.add(pq.poll()+pq.poll()*2);
        }
        
        return answer;
    }
}