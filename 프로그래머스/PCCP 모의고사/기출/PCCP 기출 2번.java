import java.util.*;

class Solution {
    static int r[] = {-1,0,1,0}, c[] = {0,1,0,-1};
    static int N, M;
    
    public int solution(int[][] land) {
        N = land.length; M = land[0].length;
        boolean check[][] = new boolean[N][M];
        ArrayList<Integer> oil = new ArrayList<Integer>();
        int idx = 0, answer = 0;
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(land[i][j] == 1) check[i][j] = true;
            }
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(check[i][j]) {
                    Queue<int[]> queue = new LinkedList<int[]>();
                    queue.add(new int[]{i,j});
                    check[i][j] = false;
                    idx++;
                    int cnt = 0;
                    
                    while(!queue.isEmpty()) {
                        int o[] = queue.poll();
                        land[o[0]][o[1]] = idx; cnt++;
                        
                        for(int d=0; d<4; d++) {
                            int dr = o[0] + r[d];
                            int dc = o[1] + c[d];
                            if(dr < 0 || dr >= N || dc < 0 || dc >= M || !check[dr][dc])  continue;
                            check[dr][dc] = false;
                            queue.add(new int[]{dr,dc});
                        }
                    }
                    
                    oil.add(cnt);
                }
            }
        }
        
        for(int i=0; i<M; i++){
            HashSet<Integer> set = new HashSet<Integer>();
            for(int j=0; j<N; j++) {
                if(land[j][i] != 0) set.add(land[j][i]-1);
            }
            
            int sum = 0;
            for(int o : set) {
                sum += oil.get(o);
            }
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
}
