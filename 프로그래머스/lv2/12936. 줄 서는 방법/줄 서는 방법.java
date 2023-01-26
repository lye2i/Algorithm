import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        long f = 1;
        int idx = 0;
        int answer[] = new int[n];
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=1; i<=n; i++){
            f *= i;
            list.add(i);
        }
        
        k--;
        
        while(idx < n) {
            f /= n - idx;
            answer[idx++] = list.remove((int) (k/f));
            k %= f;
        }
        
        return answer;        
    }
}