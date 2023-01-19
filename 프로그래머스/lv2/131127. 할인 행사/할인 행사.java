import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i=0; i+10 <= discount.length; i++){
            int j = i;
            for(; j<i+10; j++){
                map.put(discount[j], map.getOrDefault(discount[j], 0)+1);
            }
            
            for(j=0; j<want.length; j++){
                if(!map.containsKey(want[j]) || map.get(want[j]) != number[j])   break;
            }

            if(j == want.length)    answer++;
            
            map.clear();
        }
        
        return answer;
    }
}