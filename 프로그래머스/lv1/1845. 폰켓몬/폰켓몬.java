import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums) {
            if(map.containsKey(i))   map.put(i, map.get(i)+1);
            else    map.put(i, 1);
        }
        
        if(nums.length/2 <= map.size()){
            return nums.length/2;
        } else {
           return map.size(); 
        }
    }
}