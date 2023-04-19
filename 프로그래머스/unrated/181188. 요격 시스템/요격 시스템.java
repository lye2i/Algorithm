import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (a,b)->(a[1]-b[1]));
        int end = targets[0][1];
        
        for(int[] target : targets){
            if(target[0] >= end) {
                end = target[1];
                answer++;
            }
        }
        
        return answer;
    }
}