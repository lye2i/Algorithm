class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; sb.length() <= t*m; i++){
            sb.append(Integer.toString(i, n));
        }
        
        for(int i=p-1; i<t*m; i+=m){
            answer.append(sb.substring(i, i+1));
        }
        
        return answer.toString().toUpperCase();
    }
}