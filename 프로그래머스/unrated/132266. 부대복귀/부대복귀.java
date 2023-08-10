import java.util.*;

class Solution {
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int[] result = new int[n+1];
        ArrayList<Integer> road[] = new ArrayList[n+1];
        Arrays.fill(result, -1);
        for(int i=0; i<=n; i++) {
            road[i] = new ArrayList<Integer>();
        }
        for(int r[] : roads) {
            road[r[0]].add(r[1]);
            road[r[1]].add(r[0]);
        }
        
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean visit[] = new boolean[n+1];
        queue.add(new int[]{destination, 0});
        visit[destination] = true;

        while(!queue.isEmpty()) {
            int s[] = queue.poll();
            result[s[0]] = s[1];
            
            for(int r : road[s[0]]) {
                if(visit[r])    continue;
                visit[r] = true;
                queue.add(new int[]{r, s[1]+1});
            }
        }
        
        for(int i=0; i<sources.length; i++) {
            answer[i] = result[sources[i]];
        }
        
        return answer;
    }
}