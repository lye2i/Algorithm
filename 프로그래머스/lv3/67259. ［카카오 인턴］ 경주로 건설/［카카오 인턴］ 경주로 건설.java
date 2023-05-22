import java.util.*;

class Solution {
    static int r[] = {0,1,0,-1}, c[] = {1,0,-1,0};
    
    public int solution(int[][] board) {
        int N = board.length;
        int cost[][][] = new int[4][N][N];
        for(int i=0; i<4; i++) {
            for(int j=0; j<N; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int i=0; i<2; i++) {
            if(board[r[i]][c[i]] == 0) {
                cost[i][r[i]][c[i]] = 1;
                queue.add(new int[]{r[i], c[i], i, 1});
            }
        }
        
        while(!queue.isEmpty()){
            int p[] = queue.poll();
            // System.out.println(p[0]+" "+p[1]+" "+p[2]+" "+p[3]);
            
            for(int i=0; i<4; i++) {
                int dr = p[0] + r[i];
                int dc = p[1] + c[i];
                if(dr < 0 || dr >= N || dc < 0 || dc >= N || board[dr][dc] == 1)    continue;
                if(cost[i][dr][dc] >= p[3] + 1 && Math.abs(i-p[2]) != 1 && Math.abs(i-p[2]) != 3) {
                    cost[i][dr][dc] = p[3] + 1;
                    queue.add(new int[]{dr, dc, i, p[3]+1});
                }
                else if(cost[i][dr][dc] >= p[3] + 6 && (Math.abs(i-p[2]) == 1 || Math.abs(i-p[2]) == 3)){
                    cost[i][dr][dc] = p[3] + 6;
                    queue.add(new int[]{dr, dc, i, p[3]+6});
                }
            }
        }
        
        return Math.min(Math.min(Math.min(cost[0][N-1][N-1], cost[1][N-1][N-1]), cost[2][N-1][N-1]), cost[3][N-1][N-1])*100;
    }
}