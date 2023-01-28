class Solution {
    static int answer = 0;
    public void NQueen(int n, int idx, int[] array) {
        if(n == idx) {
            answer++;
            return;
        }
        
        for(int i=0; i<n; i++) {
            array[idx] = i;
            if(check(idx, array))   NQueen(n, idx+1, array);
        }
    }
    
    public boolean check(int idx, int[] array) {
        for(int i=0; i<idx; i++){
            if(array[i] == array[idx])  return false;
            if(Math.abs(i-idx) == Math.abs(array[i]-array[idx]))    return false;
        }
        return true;
    }
    
    public int solution(int n) {
        NQueen(n, 0, new int[n]);
        return answer;
    }
}