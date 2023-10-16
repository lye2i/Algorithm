import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = -1, a1 = scores[0][0], a2 = scores[0][1];
        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0])    return b[1] - a[1];
                return b[0] - a[0];
            }
        });
        
        int s1 = 100001, s2 = -1, min = -1;
        for(int[] s : scores) {
            if(s1 > s[0]) {
                s1 = s[0];
                s2 = Math.max(s2, min);
                min = -1;
            }
            
            if(s1 == s[0]) {
                min = Math.max(min, s[1]);
                if(s2 > s[1]) {
                    s[0] = -1;
                    s[1] = -1;
                }
            }
        }
        
        Arrays.sort(scores, (a,b) -> (b[0]+b[1]) - (a[0]+a[1]));
        
        int rank = 0, equal = 0, score = -1;
        for(int[] s : scores) {
            if(s[0]+s[1] == score)  equal++;
            else {
                rank += equal;
                rank++;
                equal = 0;
                score = s[0]+s[1];
            }
            
            if(s[0] == -1)  break;
            if(s[0] == a1 && s[1] == a2) {
                answer = rank;
                break;
            }
        }
        
        return answer;
    }
}