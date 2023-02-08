class Solution {
    static int answer = 50;
    private static boolean first(String target, String[] words) {
        for(String s : words) {
            if(s.equals(target)) return true;
        }
        return false;
    }
    
    private static void search(String str, String target, String[] words, boolean visit[], int cnt) {
        if(str.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            if(!visit[i] && check(str, words[i])) {
                visit[i] = true;
                search(words[i], target, words, visit, cnt+1);
                visit[i] = false;
            }
        }
    }
    
    private static boolean check(String str, String target) {
        int cnt = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != target.charAt(i))   cnt++;
            if(cnt > 1) return false;
        }
        return true;
    }
    
    public int solution(String begin, String target, String[] words) {
        if(!first(target, words))   return 0;
        search(begin, target, words, new boolean[words.length], 0);
        return answer;
    }
}