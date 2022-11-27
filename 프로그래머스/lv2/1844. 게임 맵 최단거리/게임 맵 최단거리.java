import java.util.*;

class Solution {
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,1,-1};
    
    public int game(int[][] maps){
        
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean visit[][] = new boolean[n][m];
        visit[0][0] = true;
        queue.offer(new int[]{0,0,1});
        
        while(!queue.isEmpty()){
            int[] route = queue.poll();
            if(route[0]==n-1 && route[1]==m-1) return route[2];
            
            for(int d=0; d<dr.length; d++){
                int r = route[0] + dr[d];
                int c = route[1] + dc[d];
                
                if(r>=0 && r<n && c>=0 && c<m && !visit[r][c] && maps[r][c]==1){
                    visit[r][c] = true;
                    queue.offer(new int[]{r,c,route[2]+1});
                }
            }
        }
        
        return -1;
    }
    
    public int solution(int[][] maps) {
        return game(maps);        
    }
}