class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i=1; i<=s.length()/2; i++) {
            StringBuilder sb = new StringBuilder();
            int cnt = 1, j = i;
            String str1 = s.substring(0, i);
            
            for( ; j<=s.length()-i; j+=i) {
                String str2 = s.substring(j, j+i);
                
                if(str1.equals(str2))   cnt++;
                else{
                    if(cnt == 1)    sb.append(str1);
                    else    sb.append(cnt).append(str1);
                    
                    cnt = 1;
                    str1 = str2;
                }
            }
            
            if(cnt == 1)    sb.append(str1);
            else    sb.append(cnt).append(str1);
            
            if(j < s.length())  sb.append(s.substring(j, s.length()));
            
            answer = Math.min(answer, sb.length());            
        }
        return answer;
    }
}