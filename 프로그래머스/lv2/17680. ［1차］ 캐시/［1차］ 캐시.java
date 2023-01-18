import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0, size = 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        if(cacheSize == 0)  return 5*cities.length;
        
        for(int i=0; i<cities.length; i++){
            String city = cities[i].toUpperCase();
            if(map.containsKey(city) && map.get(city) != -1){
                answer++;
                map.put(city, i);
            } else if(size < cacheSize) {
                answer += 5;
                map.put(city, i);
                size++;
            } else {
                String minCity = "";
                int minCnt = cities.length;
                for(String s : map.keySet()){
                    int cnt = map.get(s); 
                    if(cnt != -1 && cnt < minCnt) {
                        minCity = s;
                        minCnt = cnt;
                    }
                }
                
                map.put(minCity, -1);
                map.put(city, i);
                answer += 5;
            }
        }
        return answer;
    }
}