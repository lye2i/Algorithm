class Solution {
    static int answer = 0;
    
    public void combination(int[] number, int idx, boolean[] visit, int cnt){
        if(cnt == 3) {
            int score = 0;
            for(int i=0; i<number.length; i++){
                if(visit[i])  score += number[i];
            }
            if(score == 0) answer++;
            return;
        }
        
        for(int i=idx; i<number.length; i++) {
            if(!visit[i]){
                visit[i] = true;
                combination(number, i+1, visit, cnt+1);
                visit[i] = false;
            }
        }
        
    }
    
    public int solution(int[] number) {
        answer = 0;
        combination(number, 0, new boolean[number.length], 0);
        return answer;
    }
}