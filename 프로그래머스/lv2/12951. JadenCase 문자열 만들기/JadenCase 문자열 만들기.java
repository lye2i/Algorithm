class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<str.length; i++){
            if(str[i].length() == 0){
                sb.append(" ");
                continue;
            }
            
            String word = str[i].toLowerCase();
            sb.append(Character.toUpperCase(str[i].charAt(0))+word.substring(1,word.length()));
            if(i < str.length-1)  sb.append(" ");
        }
        
        if(s.charAt(s.length()-1) == ' ')   sb.append(" ");
        
        return sb.toString();
    }
}