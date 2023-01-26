import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0, cnt1 = 0, cnt2 = 0;
        HashMap<Integer, Integer> total = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> person = new HashMap<Integer, Integer>();
        
        for(int i=0; i<topping.length; i++){
            if(!total.containsKey(topping[i])) {
                total.put(topping[i], 1);
                cnt2++;
            } else  total.put(topping[i], total.get(topping[i])+1);
        }
        
        for(int i=0; i<topping.length; i++){
            if(!person.containsKey(topping[i])){
                person.put(topping[i], 1);
                cnt1++;
            }
            
            if(total.get(topping[i])-1 == 0)  cnt2--;
            total.put(topping[i], total.get(topping[i])-1);
            
            if(cnt1 == cnt2)    answer++;
        }
        
        return answer;
    }
}