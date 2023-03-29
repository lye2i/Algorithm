import java.util.*;

class Solution {
    static int N, M;
    static int r[] = {-1,0,0,1};
    static int c[] = {0,1,-1,0};
    
    public static int[] lever(String[] maps, int i, int j, int t, char A) {
        boolean visit[][] = new boolean[N][M];
        visit[i][j] = true;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{i, j, t});
        
        while(!queue.isEmpty()) {
            int m[] = queue.poll();
            
            for(int d=0; d<4; d++) {
                int dr = m[0] + r[d];
                int dc = m[1] + c[d];
                
                if(dr >= 0 && dr < N && dc >= 0 && dc < M && !visit[dr][dc]) {
                    if(maps[dr].charAt(dc) == A)  return new int[]{dr,dc,m[2]+1};
                    if(maps[dr].charAt(dc) != 'X')  {
                        visit[dr][dc] = true;
                        queue.offer(new int[]{dr, dc, m[2]+1});
                    }
                }
            }
        }
        
        return new int[]{0,0,-1};
    }
    
    public int solution(String[] maps) {
        int answer = -1;
        N = maps.length;
        M = maps[0].length();
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(maps[i].charAt(j) == 'S') {
                    int l[] = lever(maps, i, j, 0, 'L');                    
                    
                    if(l[2] != -1) {
                        int a[] = lever(maps, l[0], l[1], l[2], 'E');
                        answer = a[2];
                    }
                    break;
                }
            }
        }
        
        return answer;
    }
}