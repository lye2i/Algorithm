import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        PriorityQueue<Integer> queueA = new PriorityQueue<Integer>();
        PriorityQueue<Integer> queueB = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i=0; i<A.length; i++){
            queueA.add(A[i]);
            queueB.add(B[i]);
        }
        
        while(!queueA.isEmpty()){
            answer += queueA.peek() * queueB.peek();
            queueA.remove();
            queueB.remove();
        }
        
        return answer;
    }
}