import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        int r[] = {1,0,-1,0};
        int c[] = {0,1,0,-1};
        boolean visit[][] = new boolean[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++){
                if(picture[i][j] != 0 && !visit[i][j]) {
                    int cnt = 0;
                    Queue<int[]> queue = new LinkedList<int[]>();
                    queue.offer(new int[]{i, j});
                    visit[i][j] = true;
                    
                    while(!queue.isEmpty()){
                        int color[] = queue.poll();
                        cnt++;
                        
                        for(int d=0; d<4; d++){
                            int dr = color[0] + r[d];
                            int dc = color[1] + c[d];
                            if(dr>=0 && dr<m && dc>=0 && dc<n && !visit[dr][dc] && picture[dr][dc] == picture[i][j]) {
                                visit[dr][dc] = true;
                                queue.offer(new int[]{dr,dc});
                            }
                        }
                    }
                    
                    answer[0]++;
                    answer[1] = Math.max(answer[1], cnt);
                }
            }
        }
        
        return answer;
    }
}