import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int kg[] = new int[1001];
        
        for(int i : weights) {
            kg[i]++;
        }
        
        for(int i : weights) {
            if(i * 2 <= 1000) answer += kg[i*2];
            if(i % 2 == 0 && (i / 2) * 3 <= 1000)   answer += kg[i/2*3];
            if(i % 3 == 0 && (i / 3) * 4 <= 1000)   answer += kg[i/3*4];
        }
        
        for(int i=100; i<=1000; i++) {
            if(kg[i] > 1)   answer += (long)kg[i]*(kg[i]-1)/2;
        }
        
        return answer;
    }
}