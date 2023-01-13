class Solution {
    public int solution(int n) {
        int answer = n+1, cntN = 0;
        String strN = Integer.toBinaryString(n);
        for(int i=0; i<strN.length(); i++){
            if(strN.charAt(i) == '1')   cntN++;
        }
        
        while(true){
            int cntA = 0;
            String strA = Integer.toBinaryString(answer);
            for(int i=0; i<strA.length(); i++){
                if(strA.charAt(i) == '1')   cntA++;
            }
            
            if(cntA == cntN)    break;
            answer++;
        }
        
        return answer;
    }
}