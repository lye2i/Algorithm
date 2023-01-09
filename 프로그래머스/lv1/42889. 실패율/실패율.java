import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int success[] = new int[N+1];
        int fail[] = new int[N+1];
        HashMap<Integer, Double> rate = new HashMap<Integer, Double>();
        
        for(int i=0; i<stages.length; i++){
            for(int j=1; j<=stages[i] && j<=N; j++){
                success[j]++;
            }
            if(stages[i] <= N)   fail[stages[i]]++;
        }
        
        for(int i=1; i<=N; i++){
            if(success[i] == 0) rate.put(i, (double)0);
            else    rate.put(i, fail[i] / (double) success[i]);
        }
        
        List<Integer> keySet = new ArrayList<>(rate.keySet());
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(rate.get(o1) == rate.get(o2))  return o1-o2;
                return rate.get(o2).compareTo(rate.get(o1));
            }
        });
        
        for(int i=0; i<keySet.size(); i++){
            answer[i] = keySet.get(i);
        }
        return answer;
    }
}