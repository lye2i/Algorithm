import java.util.*;
class Solution {
    public int[] solution(String s) {
        s = s.substring(1,s.length()-1);
        String str[] = s.split("},");
        List<String> list = new ArrayList<String>();
        List<Integer> answer = new ArrayList<Integer>();
        
        for(int i=0; i<str.length; i++){
            String tuple = str[i].substring(1);
            list.add(tuple);
        }
        
        Collections.sort(list, (String s1, String s2) -> s1.length() - s2.length());
            
        for(int i=0; i<list.size(); i++){
            String tuple[] = list.get(i).split(",");
            for(int j=0; j<tuple.length; j++){
                int n = 0;
                if(tuple[j].charAt(tuple[j].length()-1) == '}')
                    n = Integer.parseInt(tuple[j].substring(0,tuple[j].length()-1));
                else    n = Integer.parseInt(tuple[j]);
                if(!answer.contains(n))   answer.add(n);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}