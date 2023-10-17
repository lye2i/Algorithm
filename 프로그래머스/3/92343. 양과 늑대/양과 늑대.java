class Solution {
    int answer = 0;
    
    public int solution(int[] info, int[][] edges) {
        dfs(0, new boolean[info.length], 0, 0, info, edges);
        return answer;
    }
    
    public void dfs(int idx, boolean[] visit, int sheep, int wolf, int[] info, int[][] edges) {
        visit[idx] = true;
        
        if(info[idx] == 1)  wolf++;
        else {
            sheep++;
            answer = Math.max(answer, sheep);
        }
        
        if(wolf >= sheep)   return;
        
        for(int[] edge : edges) {
            if(visit[edge[0]] && !visit[edge[1]]) {
                boolean visited[] = visit.clone();
                dfs(edge[1], visited, sheep, wolf, info, edges);
            }
        }
    }
}