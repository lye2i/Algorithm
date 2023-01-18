import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int min = 0, max = 0;
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        for(int i=0; i<str1.length()-1; i++){
            String s1 = str1.substring(i,i+2);
            if(s1.charAt(0) >= 'A' && s1.charAt(0) <= 'Z' && s1.charAt(1) >= 'A' && s1.charAt(1) <= 'Z')    map1.put(s1, map1.getOrDefault(s1,0)+1);
        }
        
        for(int i=0; i<str2.length()-1; i++){
           String s2 = str2.substring(i,i+2);
           if(s2.charAt(0) >= 'A' && s2.charAt(0) <= 'Z' && s2.charAt(1) >= 'A' && s2.charAt(1) <= 'Z')    map2.put(s2, map2.getOrDefault(s2,0)+1);
        }
        
        for(String s1 : map1.keySet()){
            if(map2.containsKey(s1)){
                min += Math.min(map1.get(s1), map2.get(s1));
                max += Math.max(map1.get(s1), map2.get(s1));
            }
            else    max += map1.get(s1);
        }
        
        for(String s2 : map2.keySet()){
            if(!map1.containsKey(s2))   max += map2.get(s2);
        }
        
        double answer = ((double) min / max) * 65536;
    
        return max == 0 ? 65536 : (int)answer;
    }
}