class Solution {
    public int solution(int[] stones, int k) {
        int min = 1, max = 200000000, answer = 0;
        
        while(min <= max) {
            int mid = (min + max) / 2;
            if(isPossible(stones, mid, k)) {
                answer = Math.max(answer, mid);
                min = mid + 1;                
            } else  max = mid - 1;
        }
        
        return answer;
    }
    
    public boolean isPossible(int[] stones, int mid, int k) {
        int skip = 0;
        for(int s : stones) {
            if(s - mid < 0) skip++;
            else    skip = 0;
            
            if(skip == k)   return false;
        }
        return true;
    }
}