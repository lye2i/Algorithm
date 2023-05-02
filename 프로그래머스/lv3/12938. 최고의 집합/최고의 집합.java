class Solution {
    public int[] solution(int n, int s) {
        if(n > s)    return new int[]{-1};
        
        int answer[] = new int[n];
        
        for(int i=0; i<n; i++){
            answer[i] = s/n;
        }
        
        if(s/n*n < s) {
            int i = n-1, a = s%n;
            while(a-- > 0) {
                answer[i--]++;
            }
        } else if(s/n*n > s) {
            int i = 0, a = s%n;
            while(a-- > 0) {
                answer[i++]--;
            }
        }
        
        return answer;
    }
}