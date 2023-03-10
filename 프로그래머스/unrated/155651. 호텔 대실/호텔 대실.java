import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 1;
        PriorityQueue<String> room = new PriorityQueue<String>();
        Arrays.sort(book_time, new Comparator<String[]>(){
            @Override
            public int compare(String a[], String b[]) {
                return a[0].compareTo(b[0]);
            }
        });
        
        for(int i=0; i<book_time.length; i++){
            while(!room.isEmpty() && book_time[i][0].compareTo(room.peek()) >= 0){
                room.poll();
            }
            
            String end[] = book_time[i][1].split(":");
            int hour = Integer.parseInt(end[0]);
            int minute = Integer.parseInt(end[1])+10;
            StringBuilder time = new StringBuilder();
            
            if(minute > 59) {
                minute -= 60;
                hour++;
            }
            
            time.append(hour<10 ? "0"+hour:hour).append(":");
            time.append(minute<10 ? "0"+minute:minute);
            room.add(time.toString());
            
            if(room.size() > answer)   answer = room.size();                
        }
        
        return answer;
    }
}