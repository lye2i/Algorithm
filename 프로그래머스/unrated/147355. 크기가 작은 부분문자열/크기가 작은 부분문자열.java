class Solution {
    public int solution(String t, String p) {
        Long numP = Long.parseLong(p);
        int answer = 0;
        
        for(int i=0; i+p.length() <= t.length(); i++){
            String number = t.substring(i, i+p.length());
            if(Long.parseLong(number) <= numP) 
                answer++;
        }
        
        return answer;
    }
}