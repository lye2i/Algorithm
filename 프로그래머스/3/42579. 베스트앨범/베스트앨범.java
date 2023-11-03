import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        LinkedList<Integer> answer = new LinkedList<Integer>();
        HashMap<String, LinkedList<int[]>> playMap = new HashMap<>();
        HashMap<String, Integer> sizeMap = new HashMap<>();
        
        for(int i=0; i<plays.length; i++) {
            if(!playMap.containsKey(genres[i])) playMap.put(genres[i], new LinkedList<int[]>());
            
            playMap.get(genres[i]).add(new int[]{i, plays[i]});
            sizeMap.put(genres[i], sizeMap.getOrDefault(genres[i], 0)+plays[i]);
        }
        
        LinkedList<String> list = new LinkedList<String>(sizeMap.keySet());
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                return sizeMap.get(s2) - sizeMap.get(s1);
            }
        });
        
        for(String s : list) {
            LinkedList<int[]> play = playMap.get(s);
            Collections.sort(play, (a,b) -> (b[1] - a[1]));
            answer.add(play.get(0)[0]);
            
            if(play.size() > 1) answer.add(play.get(1)[0]);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}