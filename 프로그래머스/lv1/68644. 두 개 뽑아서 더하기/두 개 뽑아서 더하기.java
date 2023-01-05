import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>(set);
        int answer[] = new int[list.size()];
        
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}