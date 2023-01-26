import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> nqueue1 = new LinkedList<Integer>();
        Queue<Integer> nqueue2 = new LinkedList<Integer>();
        int cnt = 0;
        long sum1 = 0, sum2 = 0;
        
        for(int i = 0; i < queue1.length; i++){
            nqueue1.offer(queue1[i]);
            nqueue2.offer(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        if((sum1 + sum2) % 2 == 1)  return -1;
        
        while(cnt < (queue1.length + queue2.length) * 2) {
            if(sum1 == sum2)    break;
            
            if(sum1 > sum2) {
                sum1 -= nqueue1.peek();
                sum2 += nqueue1.peek();
                nqueue2.offer(nqueue1.poll());
            } else {
                sum1 += nqueue2.peek();
                sum2 -= nqueue2.peek();
                nqueue1.offer(nqueue2.poll());
            }
            
            cnt++;
        }
        
        return cnt == (queue1.length + queue2.length) * 2 ? -1 : cnt;
    }
}