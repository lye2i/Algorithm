import java.util.*;

class Solution {
    static int N;
    static String answer[];
    
    public boolean DFS(int idx, String[][] tickets, boolean visit[]) {
        if(idx == N)    return true;
        
        for(int i=0; i<N; i++) {
            if(!visit[i] && tickets[i][0].equals(answer[idx])) {
                visit[i] = true;
                answer[idx+1] = tickets[i][1];
                if(DFS(idx+1, tickets, visit))  return true;
                visit[i] = false;
            }
        }
        
        return false;
    } 
    
    public String[] solution(String[][] tickets) {
        N = tickets.length;
        answer = new String[N+1];
        
        Arrays.sort(tickets, new Comparator<String[]>(){
            @Override
            public int compare(String a[], String b[]) {
                return a[1].compareTo(b[1]);
            }
        });
        
        answer[0] = "ICN";
        DFS(0, tickets, new boolean[N]);
        
        return answer;
    }
}