import java.util.*;

class Solution {
    static int r[] = {0,0,1,-1}, c[] = {1,-1,0,0};
    
    public int[] solution(String[] maps) {
        int R = maps.length, C = maps[0].length();
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean visit[][] = new boolean[R][C];
        
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(!visit[i][j] && maps[i].charAt(j) != 'X') {
                    Queue<int[]> queue = new LinkedList<>();
                    int cnt = maps[i].charAt(j) - '0';
                    visit[i][j] = true;
                    queue.add(new int[]{i,j});
                    
                    while(!queue.isEmpty()) {
                        int[] m = queue.poll();
                        for(int d=0; d<4; d++){
                            int dr = m[0] + r[d];
                            int dc = m[1] + c[d];
                            if(dr>=0 && dr<R && dc>=0 && dc<C && !visit[dr][dc] && maps[dr].charAt(dc) != 'X') {
                                visit[dr][dc] = true;
                                cnt += maps[dr].charAt(dc) - '0';
                                queue.add(new int[]{dr, dc});
                            }
                        }
                    }
                    
                    list.add(cnt);
                }
            }
        }
        
        if(list.size() == 0)    return new int[]{-1};
        
        Collections.sort(list);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}