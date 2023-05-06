import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int a[], int b[]) {
                return a[1] - b[1];
            }
        });
        
        int answer = 1, camera = routes[0][1];
        for(int i[] : routes) {
            if(i[0] > camera)   {
                answer++;
                camera = i[1];
            }
        }
        
        return answer;
    }
}