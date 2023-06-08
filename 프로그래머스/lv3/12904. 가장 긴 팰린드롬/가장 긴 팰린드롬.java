class Solution
{
    public int solution(String s)
    {
        int answer = 0, length = s.length();
        
        for(int i=0; i<length; i++) {
            int left = i-1, right = i+1, cnt1 = 0, cnt2 = 0;
            while(left >=0 && right < length) {
                if(s.charAt(left) != s.charAt(right))   break;
                cnt1++;
                left--;
                right++;
            }
            
            left = i; right = i+1;
            while(left >= 0 && right < length) {
                if(s.charAt(left) != s.charAt(right))   break;
                cnt2++;
                left--;
                right++;
            }
            
            answer = Math.max(answer, Math.max(cnt1*2+1, cnt2*2));
        }
        
        return answer;
    }
}