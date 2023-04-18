import java.util.*;

class Solution {
    static int r[] = {-1,1,0,0};
    static int c[] = {0,0,1,-1};
    
    public static int[] check(String[] board, int N, int M) {
        int cnt = 0;
        int R[] = new int[2];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++){
                if(board[i].charAt(j) == 'R') {
                    R[0] = i;
                    R[1] = j;
                }
                else if(board[i].charAt(j) == 'G') {
                    for(int d=0; d<4; d++) {
                        int dr = i + r[d];
                        int dc = j + c[d];
                        if(dr < 0 || dr >= N || dc < 0 || dc >= M || board[dr].charAt(dc) == 'D') cnt++;
                    }
                }
            }
        }
        
        if(cnt == 0 || cnt == 4)    return new int[]{-1, -1};
        return R;
    }
    
    public int solution(String[] board) {
        int N = board.length, M = board[0].length();
        int R[] = check(board, N, M);
        
        if(R[0] != -1) {
            Queue<int[]> queue = new LinkedList<int[]>();
            boolean visit[][] = new boolean[N][M];
            visit[R[0]][R[1]] = true;
            queue.offer(new int[]{R[0], R[1], 0});
            
            while(!queue.isEmpty()) {
                int h[] = queue.poll();
                
                for(int d=0; d<4; d++) {
                    int dr = h[0] + r[d];
                    int dc = h[1] + c[d];
                    if(dr >= 0 && dr < N && dc >= 0 && dc < M && board[dr].charAt(dc) != 'D') {
                        int i = 0;
                        while(true) {
                            int ndr = h[0] + r[d]*(i+1);
                            int ndc = h[1] + c[d]*(i+1);
                            if(ndr < 0 || ndr >= N || ndc < 0 || ndc >= M || board[ndr].charAt(ndc) == 'D' ) {
                                ndr = h[0] + r[d]*i;
                                ndc = h[1] + c[d]*i;
                                if(board[ndr].charAt(ndc) == 'G')   return h[2]+1;
                                if(!visit[ndr][ndc]) {
                                    visit[ndr][ndc] = true;
                                    queue.offer(new int[]{ndr, ndc, h[2]+1});
                                }
                                break;
                            }
                            i++;
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}