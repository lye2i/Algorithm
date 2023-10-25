class Solution {
    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];        
        for(int i=0; i<queries.length; i++) {
            answer[i] = queries[i][0] == 1 ? "Rr" : recursive(queries[i][0], queries[i][1]);
        }
        return answer;
    }
    
    public String recursive(int n, int p) {
        int idx = (int)Math.pow(4, n-1);
        if(p <= idx / 4)    return "RR";
        if(p > idx / 4 * 3) return "rr";
        if(n == 2)  return "Rr";
        if(p > idx / 4 && p <= idx / 2) return recursive(n - 1, p - idx / 4);
        return recursive(n - 1, p - idx / 2);
    }
}
