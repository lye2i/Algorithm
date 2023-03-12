class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int color = section[0];
        
        for(int i=1; i<section.length; i++){
            if(color+m <= section[i]) {
                answer++;
                color = section[i];
            }
        }
        
        return answer;
    }
}