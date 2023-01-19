class Solution {
    static int answer;
    
    public void game(int cnt, int k, int[][] dungeons, boolean visit[]) {          
        if(cnt == dungeons.length){
            answer = cnt;
            return;
        }
        
        answer = Math.max(cnt, answer);
        
        for(int i=0; i<dungeons.length; i++) {
            if(!visit[i] && dungeons[i][0] <= k) {
                visit[i] = true;
                game(cnt+1, k-dungeons[i][1], dungeons, visit);
                visit[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        game(0, k, dungeons, new boolean[dungeons.length]);
        return answer;
    }
}