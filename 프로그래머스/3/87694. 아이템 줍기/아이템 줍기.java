import java.util.*;

class Solution {
    static final int N = 101, r[] = {1, 0, -1, 0}, c[] = {0, 1, 0, -1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int map[][] = new int[N][N];
        boolean visit[][] = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<int[]>();
        
        for(int rect[] : rectangle) {
            for(int i=rect[0]*2; i<=rect[2]*2; i++) {
                for(int j=rect[1]*2; j<=rect[3]*2; j++) {
                    if(map[i][j] == 2)  continue;
                    if(i == rect[0]*2 || i == rect[2]*2 || j == rect[1]*2 || j == rect[3]*2)    map[i][j] = 1;
                    else    map[i][j] = 2;
                }
            }
        }
        
        visit[characterX*2][characterY*2] = true;
        queue.add(new int[]{characterX*2, characterY*2, 0});
        
        while(!queue.isEmpty()) {
            int point[] = queue.poll();
            if(point[0] == itemX*2 && point[1] == itemY*2)  return point[2]/2;
            for(int d=0; d<4; d++) {
                int dr = point[0] + r[d];
                int dc = point[1] + c[d];
                if(dr < 0 || dr >= N || dc < 0 || dc >= N || visit[dr][dc] || map[dr][dc] != 1) continue;
                
                visit[dr][dc] = true;
                queue.add(new int[]{dr, dc, point[2]+1});
            }
        }
        
        return 0;
    }
}