import java.util.*;

class Solution {
    static int N;
    static boolean top[][];
    
    public int bfs(int n) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean visit[] = new boolean[N+1];
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
            top[wire[0]][wire[1]] = false;
            top[wire[1]][wire[0]] = false;
            
            answer = Math.min(Math.abs(n - 2*bfs(wire[0])), answer);
            
            top[wire[0]][wire[1]] = true;
            top[wire[1]][wire[0]] = true;
        }
        
        return answer;
    }
}