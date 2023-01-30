import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int x[] = {0, 1, 1};
        int y[] = {-1, 0, -1};
        boolean flag = true;
        char[][] map = new char[m][n];
        
        for(int i=0; i<m; i++)
            map[i] = board[i].toCharArray();
        
        
        while(flag) {
            boolean visit[][] = new boolean[m][n];
            List<int[]> list = new ArrayList<int[]>();
            flag = false;
            
            for(int j=0; j<n; j++){
                for(int i=m-1; i>=0; i--){
                    if(map[i][j] == 'X')    break;
                    
                    Queue<int[]> queue = new LinkedList<int[]>();
                    queue.offer(new int[]{i, j});

                    for(int d=0; d<3; d++){
                        int dy = i + y[d];
                        int dx = j + x[d];
                        if(dy >=0 && dx < n && map[dy][dx] == map[i][j]) queue.offer(new int[]{dy, dx});
                    }

                    if(queue.size() == 4) {
                        flag = true;
                        while(!queue.isEmpty()){
                            int block[] = queue.poll();
                            if(!visit[block[0]][block[1]]) {
                                visit[block[0]][block[1]] = true;
                                list.add(new int[]{block[0], block[1]});
                            }
                        }
                    }
                    else    visit[i][j] = true;                    
                }                
            }
            
            for(int l = 0; l < list.size(); l++){
                int block[] = list.get(l);
                map[block[0]][block[1]] = 'X';
            }
            
            answer += list.size();
            
            for(int i=0; i<n; i++) {
                for(int j=m-1; j>=0; j--){
                    if(map[j][i] == 'X') {
                        for(int k=j; k>=0; k--){
                            if(map[k][i] != 'X') {
                                map[j][i] = map[k][i];
                                map[k][i] = 'X';
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}