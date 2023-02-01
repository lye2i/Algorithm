import java.util.*;

class Solution {
    static int min = 40, max = 10;
    static int answer[];
    
    private static void permutation(int n, int idx, int[] array, int[][] users, int[] emoticons) {
        if(idx == n) {            
            int money[] = new int[users.length];
            for(int i=0; i<n; i++) {
                for(int j=0; j<users.length; j++){
                    if(users[j][0] <= array[i]) {
                        money[j] += emoticons[i] / 100 * (100-array[i]);
                    }
                }
            }
            
            int total = 0, cnt = 0;
            for(int i=0; i<users.length; i++) {
                if(money[i] >= users[i][1]) cnt++;
                else    total += money[i];
            }
            
            if(cnt > answer[0]) {
                answer[0] = cnt;
                answer[1] = total;
            } else if(cnt == answer[0]) {
                answer[1] = Math.max(total, answer[1]);
            }
            
            return;
        }
        
        for(int i=min; i<=max; i+=10) {
            array[idx] = i;
            permutation(n, idx+1, array, users, emoticons);
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        for(int[] i : users) {
            if(max < i[0])  max = i[0];
            if(min > i[0])  min = i[0];
        }
        
        min = getPercent(min);
        max = getPercent(max);
        
        permutation(emoticons.length, 0, new int[emoticons.length], users, emoticons);
        return answer;
    }
    
    private static int getPercent(int n) {
        if(n > 30)    n = 40;
        else if(n > 20)    n = 30;
        else if(n > 10)    n = 20;
        else    n = 10;
        return n;
    }
}