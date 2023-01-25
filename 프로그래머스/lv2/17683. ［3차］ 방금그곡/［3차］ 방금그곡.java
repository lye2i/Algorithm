import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        int time = 0;
        String answer = "(None)";
        StringBuilder melody = new StringBuilder();
        Stack<String> stack = new Stack<String>();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("C#", "1");
        map.put("D#", "2");
        map.put("F#", "3");
        map.put("G#", "4");
        map.put("A#", "5");
        
        for(int i=m.length()-1; i>=0; i--){
            if(m.charAt(i) == '#') {
                stack.push(map.get(m.substring(i-1, i+1)));
                i--;
            } else stack.push(m.substring(i, i+1));
        }
        
        while(!stack.isEmpty()) {
            melody.append(stack.pop());
        }
        
        for(int i=0; i<musicinfos.length; i++){
            String info[] = musicinfos[i].split(",");
            String startTime[] = info[0].split(":");
            String endTime[] = info[1].split(":");
            int diff = (Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1])) - (Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]));
            List<String> iList = new ArrayList<String>();
            StringBuilder music = new StringBuilder();
            
            for(int j=info[3].length()-1; j>=0; j--){
                if(info[3].charAt(j) == '#') {
                    stack.push(map.get(info[3].substring(j-1, j+1)));
                    j--;
                } else stack.push(info[3].substring(j, j+1));
            }
        
            while(!stack.isEmpty()) {
                iList.add(stack.pop());
            }
            
            for(int j=0; j<diff; j++){
                music.append(iList.get(j%iList.size()));
            }
            
            if(melody.length() <= music.length() && music.toString().contains(melody.toString()) && time < diff){
                time = diff;
                answer = info[2];
            }
            
        }
        
        return answer;
    }
}