import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean visit[] = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(visit[i])    continue;
            
            Queue<Integer> queue = new LinkedList<Integer>();
            answer++;
            visit[i] = true;
            queue.add(i);
            
            while(!queue.isEmpty()) {
                int c = queue.poll();
                for(int j=0; j<n; j++) {
                    if(visit[j] || computers[c][j] == 0 || j == c)  continue;
                    visit[j] = true;
                    queue.add(j);
                }
            }
        }
        
        return answer;
    }
}