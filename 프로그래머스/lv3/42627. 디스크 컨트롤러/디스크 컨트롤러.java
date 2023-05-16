import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0, time = 0, idx = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        while(idx < jobs.length || !pq.isEmpty()) {
            
            while(idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(jobs[idx++]);
            }
            
            if(!pq.isEmpty()) {
                int j[] = pq.poll();
                answer += (time - j[0]) + j[1];
                time += j[1];
            }
            else    time = jobs[idx][0];
        }
        
        return answer/idx;
    }
}