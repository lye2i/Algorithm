import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int answer[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<lottos.length; i++){
            map.put(lottos[i], map.getOrDefault(lottos[i], 0) + 1);
        }
        
        for(int i=0; i<win_nums.length; i++){
            if(map.containsKey(win_nums[i])){
                map.put(win_nums[i], 0);
            }
        }
        
        int cnt = 0;
        for(Integer key : map.keySet()){
            if(map.get(key) == 0)   cnt++;
        }
        
        int best = map.getOrDefault(0, 0) + cnt;
        
        answer[0] = best == 0 ? 6 : 7 - best;
        answer[1] = cnt == 0 ? 6 : 7 - cnt;
        
        return answer;
    }
}