import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int start = 0, end = 0, left = 0, length = gems.length;
        
        for(String str : gems) {
            set.add(str);
        }
        
        for(int i=0; i<gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            
            while(map.get(gems[left]) > 1) {
                map.put(gems[left], map.get(gems[left])-1);
                left++;
            }
            
            if(map.size() == set.size() && length > i-left) {
                length = i - left;
                start = left;
                end = i;
            }
        }
        
        return new int[]{start+1, end+1};
    }
}