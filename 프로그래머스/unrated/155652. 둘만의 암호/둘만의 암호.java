class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        boolean check[] = new boolean[26];
        
        for(int i=0; i<skip.length(); i++) {
            check[skip.charAt(i) - 'a'] = true;    
        }
        
        for(int i=0; i<s.length(); i++) {
            int j = s.charAt(i) - 'a', cnt = 0;
            while(true) {
                if(!check[++j % 26]) cnt++;
                if(cnt == index)    break;
            }
            sb.append((char)(j%26 + 'a'));
        }
        
        return sb.toString();
    }
}