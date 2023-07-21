class Solution {
    public static int check(String[] cards1, String[] cards2, String[] goal, int index1, int index2, int index) {
        while(++index < goal.length) {
            if(index1 < cards1.length && goal[index].equals(cards1[index1]) && index2 < cards2.length && goal[index].equals(cards2[index2])) {
                if(check(cards1, cards2, goal, index1+1, index2, index) == goal.length || check(cards1, cards2, goal, index1, index2+1, index) == goal.length) return index;
                else    break;
            }
            else if(index1 < cards1.length && goal[index].equals(cards1[index1]))  index1++;
            else if(index2 < cards2.length && goal[index].equals(cards2[index2]))  index2++;
            else  break;
        }
                   
        return index;
    }
    
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int index = check(cards1, cards2, goal, 0, 0, -1);    
        return index == goal.length ? "Yes" : "No";
    }
}