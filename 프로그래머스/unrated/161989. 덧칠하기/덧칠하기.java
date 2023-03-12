class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean color[] = new boolean[n+1];
        
        for(int i=0; i<section.length; i++){
            if(!color[section[i]]) {
                answer++;
                for(int j=section[i]; j<=n && j<section[i]+m; j++){
                    color[j] = true;
                }
            }
        }
        
        return answer;
    }
}