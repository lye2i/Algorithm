import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String answer[] = new String[players.length];
        HashMap<String, Integer> player = new HashMap<String, Integer>();
        
        for(int i=0; i<players.length; i++){
            player.put(players[i], i);
            answer[i] = players[i];
        }
        
        for(String str : callings) {
            int n = player.get(str);
            String p = answer[n-1];
            player.put(str, n-1);
            player.put(p, n);
            answer[n] = p;
            answer[n-1] = str;
        }
        
        return answer;
    }
}