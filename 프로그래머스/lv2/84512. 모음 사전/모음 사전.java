class Solution {
    static char alphabet[] = {'A', 'E', 'I', 'O', 'U'};
    static int answer, cnt;
    
    public void dfs(String word, String str){
        if(str.equals(word)){
            answer = cnt;
            return;
        }
        
        if(str.length() == 5) return;
             
        for(int i=0; i<5; i++) {
            cnt++;
            dfs (word, str + alphabet[i]);
        }
    }
    
    public int solution(String word) {
        dfs(word, "");
        return answer;
    }
}