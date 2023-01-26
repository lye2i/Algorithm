import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;        
        boolean map[][] = new boolean[n][n];
        
        for(int i=0; i<wires.length; i++) {
            map[wires[i][0]-1][wires[i][1]-1] = true;
            map[wires[i][1]-1][wires[i][0]-1] = true;
        }
        
        for(int i=0; i<wires.length; i++) {
            map[wires[i][0]-1][wires[i][1]-1] = false;
            map[wires[i][1]-1][wires[i][0]-1] = false;
            
            int cnt = 0;
            Queue<Integer> queue = new LinkedList<Integer>();
            boolean visit[] = new boolean[n];
            queue.offer(0);
            visit[0] = true;
            
            while(!queue.isEmpty()) {
                int num = queue.poll();
                for(int j=0; j<n; j++){
                    if(!visit[j] && map[j][num]) {
                        visit[j] = true;
                        queue.offer(j);
                    }
                }
            }
            
            map[wires[i][0]-1][wires[i][1]-1] = true;
            map[wires[i][1]-1][wires[i][0]-1] = true;
            
            for(int j=0; j<n; j++){
                if(visit[j])    cnt++;
            }
            
            answer = Math.min(answer, Math.abs(n-cnt-cnt));            
        }
        
        return answer;
    }
}