import java.util.*;

class Solution {
    public long[] solution(int[][] program) {
        long[] answer = new long[11];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        Arrays.sort(program, (a,b) -> (a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]));
        
        int idx = 0;
        while(true) {
            while(idx < program.length && answer[0] >= program[idx][1]) {
                pq.add(program[idx++]);
            }
            
            if(pq.isEmpty())    answer[0] = program[idx][1];
            else {
                int p[] = pq.poll();
                answer[p[0]] += (answer[0] - p[1]);
                answer[0] += p[2];
            }
            
            if(idx == program.length && pq.isEmpty())    break;
        }
        
        return answer;
    }
}
