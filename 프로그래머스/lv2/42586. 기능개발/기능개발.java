import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = speeds.length;
        int[] answer = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            int day = (100-progresses[i])%speeds[i];
            day=(day>0)?(100-progresses[i])/speeds[i]+1:(100-progresses[i])/speeds[i];
            queue.offer(day);
        }
        
        for(int i=0; i<n; i++){
            if(queue.isEmpty()){
                answer = Arrays.copyOf(answer,i);
                break;
            }
            int day=queue.poll();
            int num=1;
            while(queue.peek()!=null && day >= queue.peek()){
                queue.poll();
                num++;
            }
            answer[i]=num;
        }
        return answer;
    }
}