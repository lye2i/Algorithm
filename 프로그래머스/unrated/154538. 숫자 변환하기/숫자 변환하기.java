import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        Queue<int[]> queue = new LinkedList<int[]>();
        int answer = -1;
        queue.add(new int[]{y, 0});
        
        while(!queue.isEmpty()) {
            int Y[] = queue.poll();
            
            if(Y[0] == x) {
                answer = Y[1];
                break;
            }
            if(Y[0]-n >= x && !set.contains(Y[0]-n)) {
                set.add(Y[0]-n);
                queue.add(new int[]{Y[0]-n, Y[1]+1});
            }
            if(Y[0]%3 == 0 && !set.contains(Y[0]/3)) {
                set.add(Y[0]/3);
                queue.add(new int[]{Y[0]/3, Y[1]+1});
            }
            if(Y[0]%2 == 0 && !set.contains(Y[0]/2)) {
                set.add(Y[0]/2);
                queue.add(new int[]{Y[0]/2, Y[1]+1});
            }
        }
        
        return answer;
    }
}