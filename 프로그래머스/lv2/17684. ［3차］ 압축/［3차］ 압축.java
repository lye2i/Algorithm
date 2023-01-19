import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int index = 27;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=1; i<27; i++){
            map.put(String.valueOf((char)(64+i)), i);
        }
        
        for(int i=0; i<msg.length(); ){
            int j = i+1;
            
            for(; j<msg.length(); j++){
                String s = msg.substring(i, j+1);
                if(!map.containsKey(s)) {
                    map.put(s, index++);
                    break;
                }
            }

            list.add(map.get(msg.substring(i,j)));
            i += j-i;
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}