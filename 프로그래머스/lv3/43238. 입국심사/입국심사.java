import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0, left = 1, right = times[times.length-1]*(long)n;
        
        while(left <= right) {
            long mid = (right + left) / 2;
            long cnt = 0;
            for(int t : times) {
                cnt += mid / t;
            }
            
            if(cnt < n)    left = mid + 1;
            else {
                right = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}