import java.util.*;
class Solution {
    static int N, M, r[] = {-1,0,1,0}, c[] = {0,1,0,-1};
    public int solution(String[] board) {
        N = board.length; M = board[0].length();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i].charAt(j) == 'R')   return BFS(i, j, board);
            }
        }
        
        return -1;
    }
    
    public int BFS(int i, int j, String board[]) {
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean visit[][] = new boolean[N][M];
        visit[i][j] = true;
        queue.add(new int[]{i, j, 0});
        
        while(!queue.isEmpty()) {
            int p[] = queue.poll();
            
            if(board[p[0]].charAt(p[1]) == 'G') return p[2];
            
            for(int d=0; d<4; d++){
                int dr = p[0] + r[d];
                int dc = p[1] + c[d];
                
                if(dr < 0 || dr >= N || dc < 0 || dc >= M || visit[dr][dc] || board[dr].charAt(dc) == 'D')   continue;
                
                int k = 1;
                while(k++ > 0) {
                    dr += r[d]; dc += c[d];
                    if(dr < 0 || dr >= N || dc < 0 || dc >= M || board[dr].charAt(dc) == 'D')   break;
                }
                dr = p[0] + r[d]*(k-1);
                dc = p[1] + c[d]*(k-1);
                if(!visit[dr][dc]) {
                    visit[dr][dc] = true;
                    queue.add(new int[] {dr, dc, p[2]+1});
                }
            }
        }
        
        return -1;
    }
}