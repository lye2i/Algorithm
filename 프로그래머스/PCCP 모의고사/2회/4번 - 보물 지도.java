import java.util.*;

class Solution {
    static int r[] = {-1, 0, 1, 0}, c[] = {0, 1, 0, -1};
    
    public int solution(int n, int m, int[][] hole) {
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean visit[][][] = new boolean[n][m][2];
        boolean holeCheck[][] = new boolean[n][m];
        
        for(int h[] : hole) {
            holeCheck[h[0]-1][h[1]-1] = true;
        }
        
        visit[0][0][0] = true;
        queue.add(new int[]{0,0,0,0});
        
        while(!queue.isEmpty()) {
            int p[] = queue.poll();
            if(p[0] == n-1 && p[1] == m-1)  return p[3];
            
            for(int d=0; d<4; d++) {
                int dr = p[0] + r[d];
                int dc = p[1] + c[d];
                if(dr < 0 || dr >= n || dc < 0 || dc >= m)   continue;
                
                if(p[2] == 0) {
                    if(!visit[dr][dc][0] && !holeCheck[dr][dc]) {
                        visit[dr][dc][0] = true;
                        queue.add(new int[]{dr, dc, 0, p[3]+1});
                    }
                    
                    dr+=r[d]; dc+=c[d];
                    if(dr >= 0 && dr < n && dc >= 0 && dc < m && !visit[dr][dc][1] && !holeCheck[dr][dc]) {
                        visit[dr][dc][1] = true;
                        queue.add(new int[]{dr, dc, 1, p[3]+1});
                    }
                } else {
                    if(visit[dr][dc][p[2]] || holeCheck[dr][dc]) continue;
                    visit[dr][dc][p[2]] = true;
                    queue.add(new int[]{dr, dc, p[2], p[3]+1});
                }
            }
        }
        
        return -1;
    }
}
