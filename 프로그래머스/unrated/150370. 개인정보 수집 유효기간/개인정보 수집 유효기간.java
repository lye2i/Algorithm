import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String todays[] = today.split("[.]");
        int year = Integer.parseInt(todays[0]);
        int month = Integer.parseInt(todays[1]);
        int answer[] = new int[privacies.length];
        int index = 0;
        HashMap<String, String> map = new HashMap<String, String>();
        
        for(int i=0; i<terms.length; i++){
            String str[] = terms[i].split(" ");
            int term = Integer.parseInt(str[1]);
            int termYear = year - term/12;
            int termMonth = month - term%12;
            
            if(termMonth < 1){
                termMonth = 12+termMonth;
                termYear -= 1;
            }
            
            if(termMonth < 10)  map.put(str[0], termYear+".0"+termMonth+"."+todays[2]);
            else    map.put(str[0], termYear+"."+termMonth+"."+todays[2]);
        }
        
        for(int i=0; i<privacies.length; i++){
            String privacy[] = privacies[i].split(" ");
            if(privacy[0].compareTo(map.get(privacy[1])) <= 0){
                answer[index++] = i+1;
            }
        }
        
        return Arrays.copyOf(answer, index);
    }
}