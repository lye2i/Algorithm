import java.util.*;

class Solution {
    static int r[] = {-1,0,0,1}, c[] = {0,1,-1,0};
    static int N, M;
    
    public static int[] lever(String[] maps, int i, int j, int t, char A) {
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean visit[][] = new boolean[N][M];
        queue.offer(new int[]{i, j, t});
        visit[i][j] = true;
        
        while(!queue.isEmpty()) {
            int m[] = queue.poll();
            
            for(int d=0; d<4; d++) {
                int dr = m[0] + r[d];
                int dc = m[1] + c[d];
                
                if(dr < 0 || dr >= N || dc < 0 || dc >= M || visit[dr][dc]) continue;
                
                if(maps[dr].charAt(dc) == A)    return new int[]{dr,dc,m[2]+1};
                if(maps[dr].charAt(dc) != 'X')  {
                    visit[dr][dc] = true;
                    queue.offer(new int[]{dr, dc, m[2]+1});
                }
            }
        }
        
        return new int[]{0,0,-1};
    }
    
    public int solution(String[] maps) {
        N = maps.length; M = maps[0].length();
        int answer = -1;
        
        L : for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(maps[i].charAt(j) == 'S') {
                    int l[] = lever(maps, i, j, 0, 'L');                    
                    
                    if(l[2] != -1) {
                        int a[] = lever(maps, l[0], l[1], l[2], 'E');
                        answer = a[2];
                    }
                    
                    break L;
                }
            }
        }
        
        return answer;
    }
}