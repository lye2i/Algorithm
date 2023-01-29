class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end-begin+1)];
        int idx = 0;
        
        for(long i = begin; i <= end; i++, idx++) {
            if(i == 1) answer[idx] = 0;
            else {
                for(int j = 2; j*j <= i; j++) {
                    if(i%j == 0 && i/j <= 10000000){
                        answer[idx] = (int) i/j;
                        break;
                    }
                }
                if(answer[idx] == 0)    answer[idx] = 1;
            }
        }
        
        return answer;
    }
}