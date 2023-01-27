import java.util.*;

class Solution {
    public static void hanoi(int n, int from, int tmp, int to, List<int[]> list) {
        if(n == 0)  return;
        
        hanoi(n-1, from, to, tmp, list);
        list.add(new int[]{from, to});
        hanoi(n-1, tmp, from, to, list);
    }
    
    public int[][] solution(int n) {
        List<int[]> list = new ArrayList<int[]>();
        hanoi(n, 1,2,3, list);
        int answer[][] = new int[list.size()][2];
        
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }
}