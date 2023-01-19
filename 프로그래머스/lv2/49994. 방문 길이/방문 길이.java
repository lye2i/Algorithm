import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int x = 0, y = 0;
        List<int[]> list = new ArrayList<int[]>();
        
        for(int i=0; i<dirs.length(); i++){
            int dx = x, dy = y;
            
            switch(dirs.charAt(i)){
                case 'U':
                    dy++;
                    break;
                case 'D':
                    dy--;
                    break;
                case 'L':
                    dx--;
                    break;
                case 'R':
                    dx++;
                    break;
            }
            
            if(dx >= -5 && dx <= 5 && dy >= -5 && dy <= 5) {
                int j = 0;
                for(; j<list.size(); j++){
                    int[] route = list.get(j);
                    if((route[0] == x && route[1] == y && route[2] == dx && route[3] == dy) || (route[0] == dx && route[1] == dy && route[2] == x && route[3] == y))    break;
                }
                
                if(j == list.size()){
                    answer++;
                    list.add(new int[]{x,y,dx,dy});
                }
                
                x = dx;
                y = dy;
            }
        }
        
        return answer;
    }
}