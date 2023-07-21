class Solution {
    
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0, index2 = 0, index = -1;
        
        while(++index < goal.length) {
            if(index1 < cards1.length && goal[index].equals(cards1[index1]))  index1++;
            else if(index2 < cards2.length && goal[index].equals(cards2[index2]))  index2++;
            else  break;
        }
        
        return index == goal.length ? "Yes" : "No";
    }
}