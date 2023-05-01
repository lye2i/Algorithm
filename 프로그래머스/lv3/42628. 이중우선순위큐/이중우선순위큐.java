import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<operations.length; i++) {
            String s[] = operations[i].split(" ");
            if(s[0].equals("I"))    pq.add(Integer.parseInt(s[1]));
            else if(!pq.isEmpty()){
                if(s[1].equals("-1"))    pq.poll();
                else {
                    PriorityQueue<Integer> tpq = new PriorityQueue<>();
                    int size = pq.size();
                    while(size-- > 1) {
                        tpq.add(pq.poll());
                    }
                    pq = tpq;
                }
            }
        }
        
        if(!pq.isEmpty()) {
            answer[1] = pq.poll();
            while(pq.size() > 1) {
                pq.poll();
            }
            if(pq.size() == 0)  answer[0] = answer[1];
            else    answer[0] = pq.poll();
        }
        
        return answer;
    }
}