class Solution {
    public int solution(int n) {
        int answer = 1;
        
        for(int i=1; i<n; i++){
            int sum = i;
            
            for(int j=i+1; j<n; j++){
                if(sum+j == n) {
                    answer++;
                    break;
                }
                
                if(sum+j > n)   break;
                sum+=j;
            }
        }
        return answer;
    }
}