import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Deque<Integer> servers = new ArrayDeque<Integer>();
        
        for(int i=0; i<24; i++) {
            if(players[i] >= m + servers.size() * m) {
                int plus = players[i]/m - servers.size();
                answer += plus;
                while(plus-- > 0) {
                    servers.add(k);
                }
            }
            
            if(!servers.isEmpty()) {
                int size = servers.size();
                while(size-- > 0) {
                    int server = servers.poll();
                    if(--server > 0)    servers.add(server);
                }
            }
            
        }
        
        return answer;
    }
}