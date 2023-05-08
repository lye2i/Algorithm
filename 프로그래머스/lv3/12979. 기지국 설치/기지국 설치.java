import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0, station = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if(stations[0] - w - 1 > 0) list.add(stations[0]-w-1);
        for(int i = 1; i<stations.length; i++){
            int s1 = stations[i-1]+w;
            int s2 = stations[i]-w;
            if(s2-s1 > 1) list.add(s2-s1-1);
        }
        if(n - (stations[stations.length-1] + w) > 0)   list.add(n - (stations[stations.length-1] + w));
        
        for(int i : list) {
            answer += i / (2*w + 1);
            if(i % (2*w+1) > 0) answer++;
        }

        return answer;
    }
}