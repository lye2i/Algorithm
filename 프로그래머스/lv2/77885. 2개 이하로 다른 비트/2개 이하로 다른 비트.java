class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] % 2 == 0) answer[i] = numbers[i]+1;
            else {
                String str = Long.toBinaryString(numbers[i]);
                int idx = str.lastIndexOf("0");
                
                if(idx == -1)   str = "10"+str.substring(0, str.length()-1);
                else    str = str.substring(0, idx) + "10" + str.substring(idx+2, str.length());
                
                answer[i] = Long.parseLong(str,2);
            }
        }
        
        return answer;
    }
}