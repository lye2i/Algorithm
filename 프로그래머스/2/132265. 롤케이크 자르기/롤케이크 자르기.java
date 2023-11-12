import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0, cnt1 = 0, cnt2 = 0;
        HashMap<Integer, Integer> person1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> person2 = new HashMap<Integer, Integer>();
        
        for(int t : topping){
            if(!person2.containsKey(t)) cnt2++;
            person2.put(t, person2.getOrDefault(t, 0) + 1);
        }
        
        for(int t : topping){
            if(!person1.containsKey(t)) cnt1++;
            person1.put(t, person1.getOrDefault(t, 0) + 1);
            
            if(person2.get(t) == 1)  cnt2--;
            person2.put(t, person2.get(t)-1);
            
            if(cnt1 == cnt2)    answer++;
        }
        
        return answer;
    }
}