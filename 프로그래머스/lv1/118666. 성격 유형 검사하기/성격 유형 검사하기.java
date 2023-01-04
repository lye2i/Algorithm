import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        char[] answer = {'R','C','J','A'};
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();       
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        
        for(int i=0; i<survey.length; i++){
            if(choices[i]%4 == 0)   continue;
            else if(choices[i]/4 == 0){
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0))+4-choices[i]%4);
            } else {               
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1))+choices[i]%4);
            }
        }
        
        if(map.get('T') > map.get('R')) answer[0] = 'T';
        if(map.get('F') > map.get('C')) answer[1] = 'F';
        if(map.get('M') > map.get('J')) answer[2] = 'M';
        if(map.get('N') > map.get('A')) answer[3] = 'N';
        
        return String.valueOf(answer);
    }
}