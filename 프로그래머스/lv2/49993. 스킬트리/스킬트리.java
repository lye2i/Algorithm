class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++){
            String s = skill_trees[i].replaceAll("[^"+skill+"]", "");
            int j=0;
            
            for(; j<s.length(); j++){
                if(skill.charAt(j) != s.charAt(j))  break;
            }
            
            if(j==s.length()) answer++;
        }
        
        return answer;
    }
}