import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<String, String>();
        List<String> list = new ArrayList<String>();
        
        for(int i=0; i<record.length; i++){
            String[] str = record[i].split(" ");
            if(str[0].equals("Enter") || str[0].equals("Change")){
                map.put(str[1], str[2]);
            }
        }
        
        for(int i=0; i<record.length; i++){
            String[] str = record[i].split(" ");
            switch(str[0]) {
                case "Enter" :
                    list.add(map.get(str[1])+"님이 들어왔습니다.");
                    break;
                case "Leave" :
                    list.add(map.get(str[1])+"님이 나갔습니다.");
                    break;
                default:
                    break;
            }
        }
        
        return list.toArray(new String[list.size()]);
    }
}