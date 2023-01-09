import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0, index = 0, i = 0;
        int score[] = new int[3];
        
        while(i < dartResult.length()-1){
            score[index] = dartResult.charAt(i) - '0';
            
            if(dartResult.charAt(i+1) == '0') {
                score[index] = 10;
                i++;
            }
            
            switch(dartResult.charAt(++i)){
                case 'D':
                    score[index] = (int) Math.pow(score[index], 2);
                    break;
                case 'T':
                    score[index] = (int) Math.pow(score[index], 3);
                    break;
            }
            
            if(i < dartResult.length()-1) {
                if(dartResult.charAt(i+1) == '*' || dartResult.charAt(i+1) == '#'){
                    score[index] = dartResult.charAt(++i) == '*' ? 2*score[index] : (-1)*score[index];
                    if(index != 0 && dartResult.charAt(i) == '*') {
                        score[index-1] = 2*score[index-1];
                    }
                }
            }
            
            i++;
            index++;
        }
        
        for(int j=0; j<3; j++){
            answer += score[j];
        }
        
        return answer;
    }
}