class Solution {
    static int N, M, answer;
    
    public void getStudent(int idx, int student[], boolean select[], int ability[][]) {
        if(idx == M) {
            int score = 0;
            for(int i=0; i<M; i++) {
                score += ability[student[i]][i];
            }
            answer = Math.max(answer, score);
            return;
        }
        
        for(int i=0; i<N; i++) {
            if(!select[i]) {
                select[i] = true;
                student[idx] = i;
                getStudent(idx+1, student, select, ability);
                select[i] = false;
            }
        }
    }
    
    public int solution(int[][] ability) {
        N = ability.length; M = ability[0].length;
        getStudent(0, new int[M], new boolean[N], ability);
        return answer;
    }
}
