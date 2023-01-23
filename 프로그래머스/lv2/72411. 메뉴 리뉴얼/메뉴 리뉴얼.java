import java.util.*;

class Solution {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    
    public void combination(int n, int idx, int cnt, char[] order, char[] array, boolean visit[]) {
        if(cnt == n) {
            String str = "";
            for(int i=0; i<cnt; i++){
                str += array[i];
            }
            map.put(str, map.getOrDefault(str,0)+1);
            return;
        }
        
        for(int i=idx; i<order.length; i++){
            if(!visit[i]) {
                visit[i] = true;
                array[cnt] = order[i];
                combination(n, i+1, cnt+1, order, array, visit);
                visit[i] = false;
            }
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        int[] check = new int[13];
        List<String> answer = new ArrayList<String>();
        
        for(int i=0; i<orders.length; i++){
            char[] order = orders[i].toCharArray();
            Arrays.sort(order);
            for(int j=0; j<course.length; j++){
                if(order.length < course[j])    break;
                combination(course[j], 0, 0, order, new char[course[j]], new boolean[order.length]);
            }
        }
        
        List<String> keySet = new ArrayList<String>(map.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        
        for(String key : keySet){
            int value = map.get(key);
            
            if(value == 1)   break;
            
            if(check[key.length()] <= value){
                answer.add(key);
                check[key.length()] = value;
            }
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[answer.size()]);
    }
}