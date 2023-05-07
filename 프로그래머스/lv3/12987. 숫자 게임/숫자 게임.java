import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0, n = A.length, idx = n-1;
        Arrays.sort(A);
        Arrays.sort(B);
        
        if(A[0] < B[idx]) {
            while(n-- > 0) {                
                if(B[idx] > A[n]) {
                    answer++;
                    idx--;
                }
            }
        }
        
        return answer;
    }
}