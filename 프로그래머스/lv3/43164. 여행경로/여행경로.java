import java.util.*;

class Solution {
    static int N;
    static String answer[];
    
    public static boolean search(int idx, boolean visit[], String[][] tickets, String city) {
        if(idx == N) {
            answer[idx] = city;
            return true;
        }
        
        for(int i=0; i<N; i++) {
            if(!visit[i] && tickets[i][0].equals(city)) {
                visit[i] = true;
                answer[idx] = city;
                if(search(idx+1, visit, tickets, tickets[i][1]))    return true;
                visit[i] = false;
            }
        }
        
        return false;
    }
    
    public String[] solution(String[][] tickets) {
        N = tickets.length;
        answer = new String[N+1];
        
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String a[], String b[]) {
                return a[1].compareTo(b[1]);
            }
        });
        
        search(0, new boolean[N], tickets, "ICN");
        
        return answer;
    }
}