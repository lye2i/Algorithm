class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char skillArray[] = skill.toCharArray();
        
        for(int i=0; i<skill_trees.length; i++){
            int index = 0;
            boolean flag = true;
            
            for(int j=0; j<skill_trees[i].length(); j++){
                for(int k=index; k<skillArray.length; k++){
                    if(skill_trees[i].charAt(j) == skillArray[k]){
                        if(k == index)  index++;
                        else    flag = false;
                        
                        break;
                    }
                }
                
                if(!flag)   break;
            }
            
            if(flag)    answer++;
        }
        
        return answer;
    }
}