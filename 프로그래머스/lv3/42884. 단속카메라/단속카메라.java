import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int a[], int b[]) {
                if(a[1] == b[1])    return b[0]-a[0];
                return a[1] - b[1];
            }
        });
        
        int answer = 1, camera = routes[0][1];
        for(int i=0; i<routes.length; i++) {
            if(routes[i][0] > camera)   {
                answer++;
                camera = routes[i][1];
            }
        }
        
        return answer;
    }
}