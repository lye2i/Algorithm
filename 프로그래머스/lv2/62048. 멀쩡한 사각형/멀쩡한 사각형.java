class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        for(int i=0; i<h; i++){
           answer += (long) i * w / h;
        }
        return answer*2;
    }
}