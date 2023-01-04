import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, ArrayList<String>> users = new HashMap<String, ArrayList<String>>();
        HashMap<String, Integer> report_list = new HashMap<String, Integer>();
        
        for(int i=0; i<id_list.length; i++){
            users.put(id_list[i], new ArrayList<String>());
        }
        
        for(int i=0; i<report.length; i++){
            String[] id = report[i].split(" ");
            if(!users.get(id[0]).contains(id[1])){
                ArrayList<String> list = users.get(id[0]);
                list.add(id[1]);
                users.put(id[0], list);
                
                if(report_list.containsKey(id[1])) report_list.put(id[1], report_list.get(id[1])+1);
                else    report_list.put(id[1], 1);
            }
        }
        
        for(int i=0; i<id_list.length; i++){
            ArrayList<String> list = users.get(id_list[i]);
            int cnt = 0;
            for(int j=0; j<list.size(); j++){
                if(report_list.get(list.get(j)) >= k)    cnt++;
            }
            answer[i] = cnt;
        }
        
        return answer;
    }
}