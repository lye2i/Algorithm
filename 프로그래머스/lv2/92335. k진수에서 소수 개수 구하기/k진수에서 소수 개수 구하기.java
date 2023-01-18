import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String N = Integer.toString(n,k);
        String[] str = N.split("0");

        for(String s : str){
            if(s.length()>0){
                long num = Long.parseLong(s);
                if(num>1 && check(num))    answer++;
            }
        }
        return answer;
    }
    
    public boolean check(Long n){
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0)    return false;
        }
        return true;
    }
}