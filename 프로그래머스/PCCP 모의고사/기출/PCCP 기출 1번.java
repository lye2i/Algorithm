class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0, answer = health, success = 0;
        for(int a[] : attacks) {
            int cnt = (a[0] - time);
            
            answer += (cnt >= bandage[0]) ? (cnt*bandage[1])+(bandage[2]*(cnt/bandage[0])) : cnt*bandage[1];
            if(health < answer) answer = health;
            if((answer -= a[1]) <= 0) break;
            time = a[0]+1;
        }
        
        return answer <= 0 ? -1 : answer;
    }
}
