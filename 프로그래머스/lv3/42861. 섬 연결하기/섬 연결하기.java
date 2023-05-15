import java.util.*;

class Solution {
    static LinkedList<Integer>[] island;
    
    public static boolean search(int a, int b) {
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean visit[] = new boolean[island.length];
        visit[a] = true;
        queue.add(new int[]{a, b});
        while(!queue.isEmpty()) {
            int l[] = queue.poll();
            for(int i : island[l[0]]) {
                if(!visit[i]) {
                    visit[i] = true;
                    queue.add(new int[]{i, l[0]});
                }
                else if(i != l[1])   return false;
            }
        }
        return true;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        island = new LinkedList[100];
        Arrays.sort(costs, new Comparator<int[]>() {
           @Override
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });
        
        for(int i=0; i<n; i++) {
            island[i] = new LinkedList<Integer>();
        }
        
        for(int i=0; i<costs.length; i++) {
            island[costs[i][0]].add(costs[i][1]);
            island[costs[i][1]].add(costs[i][0]);
            if(search(costs[i][0], costs[i][1]))    answer += costs[i][2];
            else {
                island[costs[i][0]].removeLast();
                island[costs[i][1]].removeLast();
            }
        }
        
        return answer;
    }
}