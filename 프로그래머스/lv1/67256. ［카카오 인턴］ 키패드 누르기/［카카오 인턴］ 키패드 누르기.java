import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int left = 10, right = 11;
        int location[][] = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2},{3,0},{3,2}};
        HashMap<Integer, Character> map = new HashMap<Integer, Character>();
        map.put(1,'L');
        map.put(4,'L');
        map.put(7,'L');
        map.put(3,'R');
        map.put(6,'R');
        map.put(9,'R');
        
        for(int i=0; i<numbers.length; i++){
            if(map.containsKey(numbers[i])){
                answer.append(map.get(numbers[i]));
                if(map.get(numbers[i]) == 'L')   left = numbers[i];
                else right = numbers[i];
            } else {
                int leftDistance = Math.abs(location[numbers[i]][0] - location[left][0]) + Math.abs(location[numbers[i]][1] - location[left][1]);
                int rightDistance = Math.abs(location[numbers[i]][0] - location[right][0]) + Math.abs(location[numbers[i]][1] - location[right][1]);
                if(leftDistance > rightDistance) {
                    answer.append('R');
                    right = numbers[i];
                } else if(rightDistance > leftDistance){
                    answer.append('L');
                    left = numbers[i];
                } else {
                    answer.append(hand.equals("right")?'R':'L');
                    if(hand.equals("right"))    right = numbers[i];
                    else    left = numbers[i];
                }
            }
        }
        
        return answer.toString();
    }
}