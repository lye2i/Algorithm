import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, n = 0, current_weight = 0;
        Queue<Integer> q = new LinkedList<>();
        
        while(true){
            answer++;
            
            if(q.size() == bridge_length)   current_weight -= q.poll();
            
            if(n<truck_weights.length && current_weight+truck_weights[n]<=weight){
                current_weight += truck_weights[n];
                q.offer(truck_weights[n++]);
            } else {
                q.offer(0); 
            }
            
            if(current_weight==0)   break;
        }
        
        return answer;
    }
}