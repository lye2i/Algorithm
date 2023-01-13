import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque();
        
        Arrays.sort(people);
        for(int i=0; i<people.length; i++){
            deque.add(people[i]);
        }
        
        while(deque.size() > 1) {
            if(deque.peekFirst() + deque.peekLast() <= limit){
                deque.pollFirst();
            } 
            answer++;
            deque.pollLast();
        }
            
        return deque.size() == 0 ? answer : answer+1;
    }
}