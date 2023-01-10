class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int k = Math.min(n, m);
        
        for(int i=k; i>0; i--){
            if(n%i == 0 && m%i == 0){
                answer[0] = i;
                break;
            }
        }
        
        answer[1] = n/answer[0] * m/answer[0] * answer[0];
        
        return answer;
    }
}