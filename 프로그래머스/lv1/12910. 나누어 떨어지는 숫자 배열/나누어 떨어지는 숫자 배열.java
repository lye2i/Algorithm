import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = new int[arr.length];
        int index = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor == 0) answer[index++] = arr[i];
        }
        
        if(answer[0] == 0){
            answer[0] = -1;
            return Arrays.copyOf(answer, 1);
        }
        
        Arrays.sort(answer);
        return Arrays.copyOfRange(answer, answer.length-index, answer.length);
    }
}