import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0, cnt1 = 0, cnt2 = 0;
        HashMap<Integer, Integer> total = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> person = new HashMap<Integer, Integer>();
        
        for(int t : topping){
            if(!total.containsKey(t)) {
                total.put(t, 1);
                cnt2++;
            } else  total.put(t, total.get(t)+1);
        }
        
        for(int t : topping){
            if(!person.containsKey(t)){
                person.put(t, 1);
                cnt1++;
            }
            
            if(total.get(t) == 1)  cnt2--;
            total.put(t, total.get(t)-1);
            
            if(cnt1 == cnt2)    answer++;
        }
        
        return answer;
    }
}