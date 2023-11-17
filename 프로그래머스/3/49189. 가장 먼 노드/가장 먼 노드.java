import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0, max = 1;
        int node[] = new int[n];
        boolean graph[][] = new boolean[n+1][n+1];
        for(int e[] : edge) {
            graph[e[0]][e[1]] = true;
            graph[e[1]][e[0]] = true;
        }
        
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean visit[] = new boolean[n+1];
        visit[1] = true;
        queue.offer(new int[]{1, 0}); 
        
        while(!queue.isEmpty()) {
            int e[] = queue.poll();
            for(int i=2; i<=n; i++) {
                if(i == e[0])   continue;
                if(!visit[i] && graph[e[0]][i]) {
                    visit[i] = true;
                    node[i-2] = e[1] + 1;
                    max = Math.max(max, e[1]+1);
                    queue.offer(new int[]{i, e[1]+1});
                }
            }
        }
        
        for(int i : node){
            if(i == max)  answer++;
        }
        
        return answer;
    }
}