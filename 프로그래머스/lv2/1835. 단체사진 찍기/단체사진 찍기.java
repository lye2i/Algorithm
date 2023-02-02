import java.util.*;

class Solution {
    static int answer = 0;
    static char[] kakao = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    
    private void permutation(int idx, char[] friend, boolean visit[], String[] data) {
        if(idx == 8) {            
            for(String s : data) {
                int cnt = 0;
                int num[] = new int[2];
                
                for(int i=0; i<8; i++){
                    if(friend[i] == s.charAt(0) || friend[i] == s.charAt(2))    num[cnt++] = i;
                    if(cnt == 2)    break;
                }
                
                if(!check(s.charAt(3), s.charAt(4)-'0', num[1]-num[0]-1))   return;
            }
            
            answer++;
            return;
        }
        
        for(int i=0; i<8; i++) {
            if(!visit[i]) {
                visit[i] = true;
                friend[idx] = kakao[i];
                permutation(idx+1, friend, visit, data);
                visit[i] = false;
            }
        }
    }
    
    private boolean check(char c, int n, int diff) {
        if(c == '=' && n == diff)   return true;
        else if(c == '<' && n > diff)   return true;
        else if(c == '>' && n < diff)   return true;
        else    return false;
    }
    
    public int solution(int n, String[] data) {
        answer = 0;
        permutation(0, new char[8], new boolean[8], data);
        return answer;
    }
}