import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String s : completion){
            if(map.containsKey(s))  map.replace(s, map.get(s)+1);
            else    map.put(s, 1);
        }
        
        for(String s : participant){
            if(map.containsKey(s))  map.replace(s, map.get(s)-1);
            else return s;
        }
        
        for(String key : map.keySet()){
            if(map.get(key) != 0)   return key;
        }
        
        return "answer";
    }
}