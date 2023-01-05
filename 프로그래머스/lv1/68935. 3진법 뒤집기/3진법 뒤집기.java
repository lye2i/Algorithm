class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = "";
        
        while(true){
            str += n%3;
            if(n/3 == 0)    break;
            n /= 3;
        }
        
        for(int i=str.length()-1; i>=0; i--){
            answer += Math.pow(3, str.length()-1-i)*(str.charAt(i)-'0');
        }
        
        return answer;
    }
}