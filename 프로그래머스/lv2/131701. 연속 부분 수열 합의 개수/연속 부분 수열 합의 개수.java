import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i=1; i<=elements.length; i++){
            for(int j=0; j<elements.length; j++){
                int sum = elements[j];
                for(int k=1; k<i; k++){
                    sum += elements[(j+k)%elements.length];
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}