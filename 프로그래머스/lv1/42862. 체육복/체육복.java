import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean student[] = new boolean[n];
        ArrayList<Integer> reserveList = new ArrayList<>();
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i=0; i<lost.length; i++){
            student[lost[i]-1] = true;
        }
        
        for(int i=0; i<reserve.length; i++){
            if(student[reserve[i]-1])   student[reserve[i]-1] = false;
            else reserveList.add(reserve[i]-1);
        }
        
        for(int i=0; i<reserveList.size(); i++){
            int std = reserveList.get(i);
            if(std-1 >=0 && student[std-1]){
                student[std-1] = false;
            }
            
            else if(std+1 < n && student[std+1]){
                student[std+1] = false;
            }
        }
        
        for(int i=0; i<student.length; i++){
            if(!student[i]) answer++;
        }
        
        return answer;
    }
}