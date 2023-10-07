import java.util.*;

class Solution {
    static int N;
    static boolean top[][];
    
    public int bfs(int n, boolean visit[]) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int cnt = 0;
        visit[n] = true;
        queue.add(n);
        
        while(!queue.isEmpty()) {
            int t = queue.poll();
            cnt++;
            
            for(int i=0; i<=N; i++) {
                if(top[t][i] && !visit[i]) {
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }
        
        return cnt;
    }
    
    public int solution(int n, int[][] wires) {
        N = n;
        top = new boolean[n+1][n+1];
        int answer = 100;
        
        for(int wire[] : wires) {
            top[wire[0]][wire[1]] = true;
            top[wire[1]][wire[0]] = true;
        }
        
        for(int wire[] : wires) {
            boolean visit[] = new boolean[n+1];
            
            top[wire[0]][wire[1]] = false;
            top[wire[1]][wire[0]] = false;
            
            answer = Math.min(Math.abs(bfs(wire[0], visit)-bfs(wire[1], visit)), answer);
            top[wire[0]][wire[1]] = true;
            top[wire[1]][wire[0]] = true;
        }
        
        return answer;
    }
}