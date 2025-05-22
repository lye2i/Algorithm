import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> wantMap = new HashMap<String, Integer>();
        for(int i=0; i<want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        for(int i=0; i<10; i++) {
            if(wantMap.containsKey(discount[i])) {
                wantMap.put(discount[i], wantMap.get(discount[i])-1);
            }
        }
        
        for(int i=0; i<=discount.length-10; i++) {
            boolean flag = true;
            for(String item : wantMap.keySet()) {
                if(wantMap.get(item) != 0) {
                    flag = false;
                    break;
                }
            }
            
            if(flag)    answer++;
            
            if(i == discount.length-10) break;
            
            String start = discount[i];
            String end = discount[i+10];
            if(wantMap.containsKey(start)) {
                wantMap.put(start, wantMap.get(start)+1);
            }
            if(wantMap.containsKey(end)) {
                wantMap.put(end, wantMap.get(end)-1);
            }
        }
        
        return answer;
    }
}