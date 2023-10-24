import java.util.*;

class Solution {
    static int N, M, r[] = {-1,0,1,0}, c[] = {0,1,0,-1};
    
    public int[] solution(String[] maps) {
        N = maps.length; M = maps[0].length();
        boolean visit[][] = new boolean[N][M];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(maps[i].charAt(j) == 'X' || visit[i][j])    continue;
                
                int cnt = maps[i].charAt(j)-'0';
                Queue<int[]> queue = new LinkedList<int[]>();
                queue.add(new int[]{i, j});
                visit[i][j] = true;
                
                while(!queue.isEmpty()) {
                    int p[] = queue.poll();
                    
                    for(int d=0; d<4; d++) {
                        int dr = p[0] + r[d];
                        int dc = p[1] + c[d];
                        if(dr < 0 || dr >= N || dc < 0 || dc >= M || visit[dr][dc] || maps[dr].charAt(dc) == 'X')   continue;
                        
                        visit[dr][dc] = true;
                        cnt += maps[dr].charAt(dc)-'0';
                        queue.add(new int[] {dr, dc});
                    }
                }
                
                pq.add(cnt);
            }
        }
        
        if(pq.size() == 0)  return new int[]{-1};
        
        int idx = 0, answer[] = new int[pq.size()];
        while(!pq.isEmpty()) {
            answer[idx++] = pq.poll();
        }
        return answer;
    }
}