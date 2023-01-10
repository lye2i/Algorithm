import java.util.*;

class Solution {
    public long solution(long n) {
        String str[] = String.valueOf(n).split("");
        StringBuilder sb = new StringBuilder();
        
        Arrays.sort(str);
        
        for(int i=0; i<str.length; i++){
            sb.append(str[i]);
        }
        
        return Long.parseLong(sb.reverse().toString());
    }
}