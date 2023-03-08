class Solution {
    static int floor[] = {0, 1, 2, 3, 4, 5, 4, 3, 2, 1};
    int answer = Integer.MAX_VALUE;
    
    public void search(int n, int cnt) {
        if(n < 10) {
            answer = n > 5 ? Math.min(answer, floor[n]+1+cnt) : Math.min(answer, floor[n]+cnt);
            return;
        }
        
        if(n % 10 <= 5) search(n/10, floor[n%10]+cnt);
        if(n % 10 >= 5) search(n/10+1, floor[n%10]+cnt);
    }
    
    public int solution(int storey) {
        search(storey, 0);
        return answer;
    }
}