class Solution {
    public String solution(String input_string) {
        StringBuilder sb = new StringBuilder();
        boolean eng[] = new boolean[26];
        int alpha[] = new int[26];
        
        for(int i=0; i<input_string.length(); i++) {
            int c = input_string.charAt(i) - 'a';
            
            if(alpha[c] == 0)   alpha[c] = i+1;
            else if(alpha[c] == i)    alpha[c] = i+1;
            else    eng[c] = true;
        }
        
        for(int i=0; i<26; i++) {
            if(eng[i])  sb.append((char)('a'+i));
        }
        return sb.length() == 0 ? "N" : sb.toString();
    }
}
