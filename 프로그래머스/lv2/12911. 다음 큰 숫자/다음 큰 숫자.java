class Solution {
    public int solution(int n) {
        int answer = n+1;
        int cntN = Integer.bitCount(n);
        
        while(true){
            int cntA = Integer.bitCount(answer);
            if(cntA == cntN)    break;
            answer++;
        }
        
        return answer;
    }
}