import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int n = priorities.length-1;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<=n; i++){
            queue.offer(new int[]{i, priorities[i]});
        }
        
        Arrays.sort(priorities);
        
        while(true){
            if(queue.peek()[1] == priorities[n]){
                answer++;
                n--;
                
                if(queue.poll()[0]==location)   break;
            }
            else    queue.offer(queue.poll());
        }
        
        return answer;
    }
}