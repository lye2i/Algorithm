import java.util.*;

class Solution {
    static HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for(String s : info) {
            String infos[] = s.split(" ");
            divideInfo(infos, "", 0);
        }
        
        for(String s : map.keySet())
            Collections.sort(map.get(s));
        
        for(int i=0; i<query.length; i++) {
            String str = query[i].replaceAll(" and ", "");
            String querys[] = str.split(" ");
            answer[i] = map.containsKey(querys[0]) ? binarySearch(querys[0], Integer.parseInt(querys[1])) : 0;
        }
        
        return answer;
    }
    
    private static int binarySearch(String query, int score) {
        ArrayList<Integer> list = map.get(query);
        int start = 0, end = list.size()-1;
        
        while(start <= end) {
            int idx = (start+end)/2;
            if(list.get(idx) < score)   start = idx + 1;
            else    end = idx - 1;
        }
        
        return list.size()-start;
    }
    
    private static void divideInfo(String[] info, String str, int cnt) {
        if(cnt == 4) {
            if(!map.containsKey(str)) map.put(str, new ArrayList<Integer>());
            map.get(str).add(Integer.parseInt(info[4]));
            
            return;
        }
        
        divideInfo(info, str+"-", cnt+1);
        divideInfo(info, str+info[cnt], cnt+1);
    }
}