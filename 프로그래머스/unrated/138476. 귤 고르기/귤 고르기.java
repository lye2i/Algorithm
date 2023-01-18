import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<tangerine.length; i++){
            Integer n = tangerine[i];
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        List<Integer> list = new ArrayList<Integer>(map.values());
        Collections.sort(list, (value1, value2) -> value2.compareTo(value1));
        
        for(int i=0; i<list.size(); i++){
            sum += list.get(i);
            answer++;
            
            if(sum >= k)    break;
        }
        
        return answer;
    }
}